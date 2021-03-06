package tech.tsdev.unsplashproject.view.main.home.adapter.holder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_image_view.view.*
import tech.tsdev.unsplashproject.R
import tech.tsdev.unsplashproject.data.Result

class ImageViewHolder(context: Context, parent: ViewGroup?)
    : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image_view, parent, false)) {


    fun onBind(item: Result) {
        itemView.onBind(item)
    }

    fun View.onBind(item: Result) {
//        img_view.setImageResource(resources.getIdentifier(item.fileName, "drawable", context.packageName))
        img_view.loadImage(item.urls.regular)
    }
}