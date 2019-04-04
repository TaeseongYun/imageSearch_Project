package tech.tsdev.unsplashproject.data.source.image.unsplash

import tech.tsdev.unsplashproject.network.UnsplashInterface
import tech.tsdev.unsplashproject.network.createRetrofit

class UnsplashRemoteData : UnsplashDataSource {

    companion object {
        const val UNSPLASH_URL = "https://api.unsplash.com/search/photos"
    }

    private val unsplashInterface = createRetrofit(UnsplashInterface::class.java, UNSPLASH_URL)

    override fun getSearchPhoto(keyword: String, page: Int, perPage: Int)
            = unsplashInterface.get

}