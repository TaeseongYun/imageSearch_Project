package tech.tsdev.unsplashproject.view.main.home.randomview.adapter.model

import tech.tsdev.unsplashproject.data.RandomPhoto

interface RandomPictureRecyclerModel {

    fun addItem(item: RandomPhoto)

    fun removeItem()

    fun getItem(position: Int): RandomPhoto

    fun notifyDataChanged()

    fun getItemCount(): Int

    var onClick: (Int) -> Unit
}