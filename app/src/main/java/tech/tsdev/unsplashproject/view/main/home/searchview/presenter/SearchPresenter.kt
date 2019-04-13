package tech.tsdev.unsplashproject.view.main.home.searchview.presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.tsdev.unsplashproject.data.PhotosResponse
import tech.tsdev.unsplashproject.data.source.image.unsplash.UnsplashRepository
import tech.tsdev.unsplashproject.view.main.home.searchview.adapter.model.SearchRecyclerModel

class SearchPresenter(val view: SearchContract.View,
                      private val unsplashRepository: UnsplashRepository,
                      val searchRecycler: SearchRecyclerModel) : SearchContract.Presenter {

    init {
        searchRecycler.onClick  = { imagePosition ->
            view.showBottomSheetDialog(searchRecycler.getItem(imagePosition).id)
        }
    }

    var isLoading = true
    var page = 0
    private val perPage = 50

    override fun loadKeywordImg(keyword: String) {
        unsplashRepository.getSearchPhoto(keyword, page, perPage).enqueue(object : Callback<PhotosResponse>{
            override fun onFailure(call: Call<PhotosResponse>, t: Throwable) {
                isLoading = false
            }

            override fun onResponse(call: Call<PhotosResponse>, response: Response<PhotosResponse>) {
                if(response.isSuccessful) {
                    response.body()?.let {
                        it.results.forEach {
                            searchRecycler.addItem(it)
                        }
                        searchRecycler.notifyDatachange()
                    } ?: let { view.showFailmessage("Code ${response.body()?.results}") }
                } else {
                    view.showFailmessage()
                }
                    isLoading = false
            }

        })
    }
}