package tech.tsdev.unsplashproject.view.main.home.searchview.adapter.model

import tech.tsdev.unsplashproject.data.Result

interface SearchRecyclerModel {
    fun addItem(item: Result)

    fun getItemCount(): Int

    fun notifyDatachange()

    var onClick: (Int) -> Unit

    fun getItem(position: Int): Result
}