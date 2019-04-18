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
    private val unsplashRepository: UnsplashRepository
) : RandomPictureContract.Presenter {

    private var _count = 30
    var isLoading = false

    init {
        randomPictureRecyclerModel.onClick = { position ->
            view.showBottomSheet(randomPictureRecyclerModel.getItem(position).id)
        }

        //처음 액티비티 실행 될때만 Progress_bar 보이게 하려고 init 초기화 블록에다 showProgressbar() 넣어줌줌
       view.showProgressbar()
    }


    override fun loadRandomImage() {
        isLoading = true



        unsplashRepository.getRandomPhoto(_count).enqueue(object : Callback<List<RandomPhoto>> {
            override fun onFailure(call: Call<List<RandomPhoto>>, t: Throwable) {
                view.dismissProgressbar()
                view.showErrorMessage()

                isLoading = false
            }

            override fun onResponse(call: Call<List<RandomPhoto>>, response: Response<List<RandomPhoto>>) {
                if (response.isSuccessful) {
                    response.body()?.let { randomPhotoList ->
                        randomPhotoList.forEach { randomPhoto ->
                            randomPictureRecyclerModel.addItem(randomPhoto)
                        }

                        randomPictureRecyclerModel.notifyDataChanged()
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