package tech.tsdev.unsplashproject.view.main.home.presenter


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.tsdev.unsplashproject.data.PhotosResponse
import tech.tsdev.unsplashproject.data.source.image.unsplash.UnsplashRepository
import tech.tsdev.unsplashproject.view.main.home.adapter.model.ImageRecyclerModel

class SearchPresenter(val view: SearchContract.View,
                      private val unSplashRepository: UnsplashRepository,
                      private val imageRecyclerModel: ImageRecyclerModel) : SearchContract.Presenter {


    var isLoading = false
    private var page = 2
    private val perPage = 50

    override fun loadImage() {
        isLoading = true
        view.showProgressbar()

        unSplashRepository.getPhotoList(++page, perPage)
            .enqueue(object : Callback<PhotosResponse>{
                override fun onFailure(call: Call<PhotosResponse>, t: Throwable) {
                    view.hideProgressbar()
                    view.showLoadFail()

                    isLoading = false
                }

                override fun onResponse(call: Call<PhotosResponse>, response: Response<PhotosResponse>?) {
                    if(response?.isSuccessful == true) {
                        response.body()?.let {

                            it.results.forEach {result ->
                                imageRecyclerModel.addItem(result)
                            }
                            imageRecyclerModel.notifyDataSetChang()
                        }?:let {
                            view.showLoadFail("Code erros")
                        }
                    } else{
                        view.showLoadFail()
                    }
                    view.hideProgressbar()

                    isLoading = false
                }
            })
    }

}