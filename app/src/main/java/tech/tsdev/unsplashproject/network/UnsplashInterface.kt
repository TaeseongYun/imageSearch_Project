package tech.tsdev.unsplashproject.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import tech.tsdev.unsplashproject.data.PhotosResponse




interface  UnsplashInterface {

    @GET("?client_id=50fda0b295b432b006dc70b08f3ca128a32efa16f92cec67d97cb41d559d3ff1")
    fun getUnsplashSearchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): Call<PhotosResponse>

    @GET("?client_id=50fda0b295b432b006dc70b08f3ca128a32efa16f92cec67d97cb41d559d3ff1")
    fun getUnsplashPhotos(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): Call<PhotosResponse>
}