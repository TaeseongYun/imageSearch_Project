package tech.tsdev.unsplashproject.view.main.home.randomview.presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.tsdev.unsplashproject.data.RandomPhoto
import tech.tsdev.unsplashproject.data.source.image.unsplash.UnsplashRepository
import tech.tsdev.unsplashproject.view.main.home.randomview.adapter.model.RandomPictureRecyclerModel

class RandomPicturePresenter(
    val view: RandomPictureContract.View,
    val randomPictureRecyclerModel: RandomPictureRecyclerModel,
    val unsplashRepository: UnsplashRepository
) : RandomPictureContract.Presenter {

    init {
        randomPictureRecyclerModel.onClick = { position ->
            view.showBottomSheet(randomPictureRecyclerModel.getItem(position).id)
        }
    }

    private var _count = 30
    var isLoading = false
    override fun loadRandomImage() {
        isLoading = true
        view.dismissProgressbar()
        unsplashRepository.getRandomPhoto(_count).enqueue(object : Callback<List<RandomPhoto>> {
            override fun onFailure(call: Call<List<RandomPhoto>>, t: Throwable) {
                view.showProgressbar()
                view.showErrorMessage()

                isLoading = false
            }

            override fun onResponse(call: Call<List<RandomPhoto>>, response: Response<List<RandomPhoto>>) {
                if (response.isSuccessful) {
                    response.body()?.let { randomPhotoList ->
                        randomPhotoList.forEach { randomPhoto ->
                            randomPictureRecyclerModel.addItem(randomPhoto)
                        }
                    } ?: let {
                        view.showErrorMessage("Code errors")
                    }
                    _count += 10
                } else {
                    view.showErrorMessage()
                }
                view.dismissProgressbar()

                isLoading = false
            }

        })
    }

}