package tech.tsdev.unsplashproject.view.main.home.adapter.model



import tech.tsdev.unsplashproject.data.Result

interface ImageRecyclerModel {
    fun addItem(imageData: Result)

    fun getItemCount(): Int

    fun notifyDataSetChang()

    fun getItem(position: Int): Result
    var onClick: (Int) -> Unit
}