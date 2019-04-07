package tech.tsdev.unsplashproject.data.source.image.unsplash


import retrofit2.Call
import tech.tsdev.unsplashproject.data.LatestPhotos
import tech.tsdev.unsplashproject.data.PhotosResponse
import tech.tsdev.unsplashproject.data.Result
import tech.tsdev.unsplashproject.data.SinglePhoto


interface UnsplashDataSource {

    fun getSearchPhoto(keyword: String, page:Int, perPage: Int): Call<PhotosResponse>

    fun getPhotoDetail(photoId: String): Call<SinglePhoto>

    fun getLatestPhoto(page: Int, per_page: Int): Call<List<LatestPhotos>>
}