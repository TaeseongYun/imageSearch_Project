package tech.tsdev.unsplashproject.view.main.home.detailsearch.adapter.holder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_image_view.view.*
import tech.tsdev.unsplashproject.R
import tech.tsdev.unsplashproject.data.PhotosResponse
import tech.tsdev.unsplashproject.data.Result
import tech.tsdev.unsplashproject.data.Urls


class DetailRecyclerHolder(onClick: (Int)->Unit, context: Context, parent: ViewGroup?)
    : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image_view, parent, false)){

    init {
        itemView.setOnClickListener {
            onClick(adapterPosition)
        }
    }

    fun onBind(item: Result) {
        itemView.onBind(item)
    }
    private fun View.onBind(item: Result) {
        img_view.loadImage(item.urls.regular)
        iv_user_name.text = item.user.username
    }
}