package tech.tsdev.unsplashproject.view.main.home.detailsearch.adapter.model



import tech.tsdev.unsplashproject.data.RandomSearchPhoto


interface DetailRecyclerModel {
    fun addItem(imageData: RandomSearchPhoto)

    fun notifyDataChange()

    fun getItemCount(): Int

    fun getItem(position: Int): RandomSearchPhoto

    var onClick: (Int) -> Unit
}