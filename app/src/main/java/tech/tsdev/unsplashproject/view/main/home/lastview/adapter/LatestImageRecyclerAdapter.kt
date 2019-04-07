package tech.tsdev.unsplashproject.view.main.home.lastview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tech.tsdev.unsplashproject.data.LatestPhotos
import tech.tsdev.unsplashproject.data.Result
import tech.tsdev.unsplashproject.view.main.home.lastview.adapter.holder.LatestPictureHolder
import tech.tsdev.unsplashproject.view.main.home.lastview.adapter.model.LatestRecyclerModel

class LatestImageRecyclerAdapter(val context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), LatestRecyclerModel {


//    override lateinit var onClick: (Int) -> Unit
    private val list = mutableListOf<LatestPhotos>()


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder{
        return LatestPictureHolder(context!!, p0)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as LatestPictureHolder).onBind(list[position])
    }

    override fun addItem(itemData: LatestPhotos) {
        list.add(itemData)
    }

    override fun notifyDataChange() {
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): LatestPhotos = list[position]
}