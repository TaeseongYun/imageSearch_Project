package tech.tsdev.unsplashproject.view.main.home.lastview.adapter.model

import tech.tsdev.unsplashproject.data.LatestPhotos


interface LatestRecyclerModel {

    fun addItem(itemData: LatestPhotos)

    fun notifyDataChange()

    fun getItem(position: Int): LatestPhotos

    fun getItemCount(): Int

//    var onClick: (Int) -> Unit
}