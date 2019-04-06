package tech.tsdev.unsplashproject.view.main.home.detailsearch.presenter


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.tsdev.unsplashproject.data.PhotosResponse
import tech.tsdev.unsplashproject.data.source.image.unsplash.UnsplashRepository
import tech.tsdev.unsplashproject.view.main.home.detailsearch.adapter.model.DetailRecyclerModel

class DetailSearchPresenter(val view: DetailSearchContract.View,
                            private val unSplashRepository: UnsplashRepository,
                            val detailImageRecyclerModel: DetailRecyclerModel) : DetailSearchContract.Presenter {

    var isLoading = true

    private var page = 0
    private val perPage = 50

    init {
        detailImageRecyclerModel.onClick = { imagePosition ->
            view.showBottomSheetDialog(detailImageRecyclerModel.getItem(imagePosition).id)
        }
    }
    override fun loadUnsplashImage(keyword: String) {
        unSplashRepository.getSearchPhoto(keyword, ++page, perPage)
            .enqueue(object: Callback<PhotosResponse>{
                override fun onFailure(call: Call<PhotosResponse>, t: Throwable) {
                    isLoading = false
                }

                override fun onResponse(call: Call<PhotosResponse>, response: Response<PhotosResponse>?) {
                    if(response?.isSuccessful == true) {

                        response.body()?.let {
                            it.results.forEach { result ->
                                detailImageRecyclerModel.addItem(result)
                            }
                            detailImageRecyclerModel.notifyDataChange()
                        } ?: let { view.showFailmessage("Code ${response.body()?.results}") }
                    } else {
                        view.showFailmessage()
                    }
                    isLoading = false
                }
            })
    }

}