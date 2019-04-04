package tech.tsdev.unsplashproject.data.source.image

import tech.tsdev.unsplashproject.data.ImageData

object ImageRepository : ImageDataSource {

    private val imageLocalData: ImageLocalData by lazy {
        ImageLocalData()
    }
    override fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        imageLocalData.loadImageList(imageDataList,size)
    }

}