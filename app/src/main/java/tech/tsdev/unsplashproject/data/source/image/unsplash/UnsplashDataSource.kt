package tech.tsdev.unsplashproject.data.source.image.unsplash

interface UnsplashDataSource {

    fun getSearchPhoto(keyword: String, page: Int, perPage: Int)
}