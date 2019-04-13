package tech.tsdev.unsplashproject.data.source.image.unsplash


import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import tech.tsdev.unsplashproject.data.*


interface UnsplashDataSource {

    fun getSearchPhoto(keyword: String, page:Int, perPage: Int): Call<PhotosResponse>

    fun getPhotoDetail(photoId: String): Call<SinglePhoto>

    fun getLatestPhoto(page: Int, per_page: Int): Call<List<LatestPhotos>>

    fun getDownloadImg(userId: String): Call<JSONObject>
}