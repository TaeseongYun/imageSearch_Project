package tech.tsdev.unsplashproject.data.source.image.unsplash

import retrofit2.Call
import tech.tsdev.unsplashproject.data.PhotosResponse



interface UnsplashDataSource {

    fun getSearchPhoto(keyword: String, page:Int, perPage: Int): Call<PhotosResponse>

    fun getPhotoList(page: Int, per_page: Int): Call<PhotosResponse>
}