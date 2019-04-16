package tech.tsdev.unsplashproject.data.source.image.unsplash


import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import tech.tsdev.unsplashproject.data.*


interface UnsplashDataSource {

    fun getSearchPhoto(keyword: String, count:Int): Call<List<RandomSearchPhoto>>

    fun getPhotoDetail(photoId: String): Call<SinglePhoto>

    fun getLatestPhoto(page: Int, per_page: Int): Call<List<LatestPhotos>>

    fun getDownloadImg(userId: String): Call<JSONObject>
}