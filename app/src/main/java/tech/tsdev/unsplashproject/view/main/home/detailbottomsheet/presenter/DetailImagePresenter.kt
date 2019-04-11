package tech.tsdev.unsplashproject.view.main.home.detailbottomsheet.presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.tsdev.unsplashproject.data.SinglePhoto
import tech.tsdev.unsplashproject.data.source.image.unsplash.UnsplashRepository


class DetailImagePresenter(val view: DetailImageContract.View,
                           private val unSplashRepository: UnsplashRepository) : DetailImageContract.Presenter {
    override fun loadDetailInfo(photoId: String) {
        unSplashRepository.getPhotoDetail(photoId).enqueue(object : Callback<SinglePhoto?>{
            override fun onFailure(call: Call<SinglePhoto?>, t: Throwable) {

            }

            override fun onResponse(call: Call<SinglePhoto?>, response: Response<SinglePhoto?>) {
                if(response.isSuccessful) {
                    response.body()?.let {
                        view.updateItem(it.urls.regular
                            , it?.let { it.alt_description } ?: let { "Empty_Description" }
                            , it.user.total_likes
                            , it.user.total_photos)
                        view.updateToolbarItem(
                            it.user.profile_image.medium,
                            it.user.username
                        )
                    }?: let { view. showLoadErrorToast() }
                }
            }

        })
    }

}