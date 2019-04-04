package tech.tsdev.unsplashproject.data.source.image

import tech.tsdev.unsplashproject.data.ImageData

interface ImageDataSource {
    fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int)
}