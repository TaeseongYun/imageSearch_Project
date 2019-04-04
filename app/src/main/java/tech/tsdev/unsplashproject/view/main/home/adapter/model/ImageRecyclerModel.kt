package tech.tsdev.unsplashproject.view.main.home.adapter.model

import tech.tsdev.unsplashproject.data.ImageData

interface ImageRecyclerModel {
    fun addItem(imageData: ImageData)

    fun getItemCount(): Int

    fun notifyDataSetChang()
}