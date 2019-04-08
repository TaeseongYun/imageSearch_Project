package tech.tsdev.unsplashproject.view.main.home.lastview.presenter



import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.tsdev.unsplashproject.data.LatestPhotos
import tech.tsdev.unsplashproject.data.source.image.unsplash.UnsplashRepository
import tech.tsdev.unsplashproject.view.main.home.lastview.adapter.model.LatestRecyclerModel

class LatestPicturePresenter(val view: LatestPictureContract.View,
                             private val unSplashRepository: UnsplashRepository,
                             private val latestImageRecyclerModel: LatestRecyclerModel) : LatestPictureContract.Presenter {


    var isLoading = false
    private var page = 0
    private val perPage = 30

    init {
        latestImageRecyclerModel.onClick = {position ->
            view.showBottomSheetDialog(latestImageRecyclerModel.getItem(position).id)
        }
    }

    override fun loadImage() {
        isLoading = true
        view.showProgressbar()

        unSplashRepository.getLatestPhoto(++page, perPage)
            .enqueue(object : Callback<List<LatestPhotos>>{
                override fun onFailure(call: Call<List<LatestPhotos>>, t: Throwable) {
                    view.hideProgressbar()
                    view.showLoadFail()

                    isLoading = false
                }

                override fun onResponse(call: Call<List<LatestPhotos>>, response: Response<List<LatestPhotos>>?) {
                    if(response?.isSuccessful == true) {
                        response.body()?.let {
                            it.forEach {latesphotos ->
                                latestImageRecyclerModel.addItem(latesphotos)
                            }

                            latestImageRecyclerModel.notifyDataChange()
                        }?:let {
                            view.showLoadFail("Code erros")
                        }
                    } else{
                        view.showLoadFail()
                    }
//                    view.hideProgressbar()

                    isLoading = false
                }
            })
    }

}