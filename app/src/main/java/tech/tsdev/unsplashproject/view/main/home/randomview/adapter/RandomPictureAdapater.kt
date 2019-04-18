package tech.tsdev.unsplashproject.view.main.home.randomview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tech.tsdev.unsplashproject.data.RandomPhoto
import tech.tsdev.unsplashproject.view.main.home.randomview.adapter.holder.RandomPictureHolder
import tech.tsdev.unsplashproject.view.main.home.randomview.adapter.model.RandomPictureRecyclerModel

class RandomPictureAdapater(private val context: Context?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), RandomPictureRecyclerModel {

    val list = mutableListOf<RandomPhoto>()

    override lateinit var onClick: (Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {
        return RandomPictureHolder(onClick, context!!, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RandomPictureHolder).onBind(list[position])
    }

    override fun addItem(item: RandomPhoto) {
        list.add(item)
    }

    override fun getItem(position: Int): RandomPhoto = list[position]

    override fun notifyDataChanged() {
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

}