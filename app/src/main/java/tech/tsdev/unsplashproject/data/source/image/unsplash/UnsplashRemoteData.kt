package tech.tsdev.unsplashproject.data.source.image.unsplash


import retrofit2.Call
import tech.tsdev.unsplashproject.data.LatestPhotos
import tech.tsdev.unsplashproject.data.PhotosResponse
import tech.tsdev.unsplashproject.data.Result
import tech.tsdev.unsplashproject.network.UnsplashInterface
import tech.tsdev.unsplashproject.network.createRetrofit


class UnsplashRemoteData : UnsplashDataSource {



    companion object {
        const val UNSPLASH_URL = "https://api.unsplash.com/search/photos/"
        const val UNSPLASH_PHOTOLIST_URL = "https://api.unsplash.com/photos/"
        const val UNSPLASH_USERNAME = "https://api.unsplash.com/photos/"
    }



    private val unSplashInterface = createRetrofit(UnsplashInterface::class.java, UNSPLASH_URL)

    private val unSplashInterfaceDetailUser = createRetrofit(UnsplashInterface::class.java, UNSPLASH_USERNAME)

    private val unSplashInterfaceLatestPhotos = createRetrofit(UnsplashInterface::class.java, UNSPLASH_USERNAME)

    override fun getSearchPhoto(keyword: String, page: Int, perPage: Int)
            = unSplashInterface.getUnsplashSearchPhotos(keyword, page, perPage)

    override fun getPhotoDetail(photoId: String) =
            unSplashInterfaceDetailUser.getDetailInfo(photoId)

    override fun getLatestPhoto(page: Int, per_page: Int): Call<List<LatestPhotos>>
            =  unSplashInterfaceLatestPhotos.getUpsplashLatestPhotos(page, per_page)
}