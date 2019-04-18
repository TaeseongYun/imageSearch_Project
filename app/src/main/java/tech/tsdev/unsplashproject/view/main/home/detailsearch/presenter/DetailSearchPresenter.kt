package tech.tsdev.unsplashproject.view.main.home.detailsearch.presenter


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.tsdev.unsplashproject.data.PhotosResponse
import tech.tsdev.unsplashproject.data.RandomSearchPhoto
import tech.tsdev.unsplashproject.data.source.image.unsplash.UnsplashRepository
import tech.tsdev.unsplashproject.view.main.home.detailsearch.adapter.model.DetailRecyclerModel

class DetailSearchPresenter(
    val view: DetailSearchContract.View,
    private val unSplashRepository: UnsplashRepository,
    private val detailImageRecyclerModel: DetailRecyclerModel
) : DetailSearchContract.Presenter {

    var isLoading = true

    private var page = 30

    init {
        detailImageRecyclerModel.onClick = { imagePosition ->
            view.showBottomSheetDialog(detailImageRecyclerModel.getItem(imagePosition).id)
        }
    }

    override fun loadUnsplashImage(keyword: String) {
        unSplashRepository.getSearchPhoto(keyword, page)
            .enqueue(object : Callback<List<RandomSearchPhoto>> {
                override fun onFailure(call: Call<List<RandomSearchPhoto>>, t: Throwable) {
                    isLoading = false
                }

                override fun onResponse(
                    call: Call<List<RandomSearchPhoto>>,
                    response: Response<List<RandomSearchPhoto>>?
                ) {
                    if (response?.isSuccessful == true) {

                        response.body()?.let {
                            it.forEach { randomPhoto ->
                                detailImageRecyclerModel.addItem(randomPhoto)
                            }
                            detailImageRecyclerModel.notifyDataChange()
                        } ?: let {
                            view.showFailmessage("Code Error")
                        }
                        page += 10
                    } else {
                        view.showFailmessage()
                    }
                    isLoading = false
                }
            })
    }

}