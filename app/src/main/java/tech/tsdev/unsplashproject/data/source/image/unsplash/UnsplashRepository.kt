package tech.tsdev.unsplashproject.data.source.image.unsplash

import retrofit2.Call
import tech.tsdev.unsplashproject.data.LatestPhotos
import tech.tsdev.unsplashproject.data.PhotosResponse
import tech.tsdev.unsplashproject.data.Result


object UnsplashRepository : UnsplashDataSource{



    private val unSplashRemoteData = UnsplashRemoteData()

    override fun getSearchPhoto(keyword: String,  page: Int, perPage: Int): Call<PhotosResponse>
            = unSplashRemoteData.getSearchPhoto(keyword, page ,perPage)

    override fun getPhotoList(page: Int, per_page: Int): Call<PhotosResponse>
            = unSplashRemoteData.getPhotoList(page, per_page)

    override fun getPhotoDetail(photoId: String)
            = unSplashRemoteData.getPhotoDetail(photoId)

    override fun getLatestPhoto(): Call<List<LatestPhotos>>
            = unSplashRemoteData.getLatestPhoto()
}