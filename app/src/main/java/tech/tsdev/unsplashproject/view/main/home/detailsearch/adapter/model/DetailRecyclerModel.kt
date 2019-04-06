package tech.tsdev.unsplashproject.view.main.home.detailsearch.adapter.model


import tech.tsdev.unsplashproject.data.PhotosResponse
import tech.tsdev.unsplashproject.data.Result

interface DetailRecyclerModel {
    fun addItem(imageData: Result)

    fun notifyDataChange()

    fun getItemCount(): Int

    fun getItem(position: Int): Result

    var onClick: (Int) -> Unit
}