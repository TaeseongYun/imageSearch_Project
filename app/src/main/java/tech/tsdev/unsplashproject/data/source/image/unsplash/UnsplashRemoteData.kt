package tech.tsdev.unsplashproject.data.source.image.unsplash


import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import tech.tsdev.unsplashproject.data.*
import tech.tsdev.unsplashproject.network.UnsplashInterface
import tech.tsdev.unsplashproject.network.createRetrofit


class UnsplashRemoteData : UnsplashDataSource {



    companion object {
        const val UNSPLASH_URL = "https://api.unsplash.com/"
        const val UNSPLASH_USERNAME = "https://api.unsplash.com/photos/"
    }


    private val unSplashInterface = createRetrofit(UnsplashInterface::class.java, UNSPLASH_URL)

    private val unSplashInterfaceDetailUser = createRetrofit(UnsplashInterface::class.java, UNSPLASH_USERNAME)

    private val unSplashInterfaceLatestPhotos = createRetrofit(UnsplashInterface::class.java, UNSPLASH_USERNAME)

    private val unSplashInterfaceDownloadImg = createRetrofit(UnsplashInterface::class.java, UNSPLASH_USERNAME)

    override fun getSearchPhoto(keyword: String, count: Int) =
        unSplashInterface.getUnsplashSearchPhotos(keyword, count)

    override fun getPhotoDetail(photoId: String) =
        unSplashInterfaceDetailUser.getDetailInfo(photoId)

    override fun getLatestPhoto(page: Int, per_page: Int): Call<List<LatestPhotos>> =
        unSplashInterfaceLatestPhotos.getUpsplashLatestPhotos(page, per_page)

    override fun getDownloadImg(userId: String): Call<JSONObject> =
        unSplashInterfaceDownloadImg.getDownloadImage(userId)

    override fun getRandomPhoto(count: Int): Call<List<RandomPhoto>> =
            unSplashInterface.getRandomPhoto(count)
}