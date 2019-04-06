package tech.tsdev.unsplashproject.view.main.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tech.tsdev.unsplashproject.data.Result
import tech.tsdev.unsplashproject.view.main.home.adapter.holder.ImageViewHolder
import tech.tsdev.unsplashproject.view.main.home.adapter.model.ImageRecyclerModel

class ImageRecyclerAdapter(private val context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
    , ImageRecyclerModel {


    private val list = mutableListOf<Result>()

    override lateinit var onClick: (Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder
            = ImageViewHolder(context!!, parent)

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, position: Int) {
        (p0 as? ImageViewHolder)?.onBind(list[position])
    }
    override fun addItem(imageData: Result) {
        list.add(imageData)
    }

    override fun getItem(position: Int): Result
        = list[position]

    override fun getItemCount(): Int
            = list.size

    override fun notifyDataSetChang()
            = notifyDataSetChanged()

}