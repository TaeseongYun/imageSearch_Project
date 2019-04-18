package tech.tsdev.unsplashproject.data.source.image.unsplash


import org.json.JSONObject
import retrofit2.Call
import tech.tsdev.unsplashproject.data.LatestPhotos
import tech.tsdev.unsplashproject.data.RandomPhoto
import tech.tsdev.unsplashproject.data.RandomSearchPhoto


object UnsplashRepository : UnsplashDataSource {



    private val unSplashRemoteData = UnsplashRemoteData()

    override fun getSearchPhoto(keyword: String, count: Int): Call<List<RandomSearchPhoto>> =
        unSplashRemoteData.getSearchPhoto(keyword, count)


    override fun getPhotoDetail(photoId: String) = unSplashRemoteData.getPhotoDetail(photoId)

    override fun getLatestPhoto(page: Int, per_page: Int): Call<List<LatestPhotos>> =
        unSplashRemoteData.getLatestPhoto(page, per_page)

    override fun getDownloadImg(userId: String): Call<JSONObject> = unSplashRemoteData.getDownloadImg(userId)

    override fun getRandomPhoto(count: Int): Call<List<RandomPhoto>> = unSplashRemoteData.getRandomPhoto(count)
}