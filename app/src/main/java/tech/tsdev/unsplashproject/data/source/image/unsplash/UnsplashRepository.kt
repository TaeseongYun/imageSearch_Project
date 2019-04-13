package tech.tsdev.unsplashproject.data.source.image.unsplash

import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import tech.tsdev.unsplashproject.data.Download
import tech.tsdev.unsplashproject.data.LatestPhotos
import tech.tsdev.unsplashproject.data.PhotosResponse


object UnsplashRepository : UnsplashDataSource {


    private val unSplashRemoteData = UnsplashRemoteData()

    override fun getSearchPhoto(keyword: String, page: Int, perPage: Int): Call<PhotosResponse> =
        unSplashRemoteData.getSearchPhoto(keyword, page, perPage)


    override fun getPhotoDetail(photoId: String) = unSplashRemoteData.getPhotoDetail(photoId)

    override fun getLatestPhoto(page: Int, per_page: Int): Call<List<LatestPhotos>> =
        unSplashRemoteData.getLatestPhoto(page, per_page)

    override fun getDownloadImg(userId: String): Call<JSONObject> = unSplashRemoteData.getDownloadImg(userId)
}