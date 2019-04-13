package tech.tsdev.unsplashproject.view.main.home.searchview.adapter.holder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_image_view.view.*
import tech.tsdev.unsplashproject.R
import tech.tsdev.unsplashproject.data.Result

class SearchRecyclerHolder(onClick: (Int) -> Unit, context: Context, viewGroup: ViewGroup?) :
    RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image_view, viewGroup, false)) {


    init {
        itemView.setOnClickListener {
            onClick(adapterPosition)
        }
    }
   fun onBind(item: Result){
       itemView.onBind(item)
   }

    private fun View.onBind(item: Result) {
        img_unsplash_user.loadProfileImage(item.user.profile_image.medium)
        iv_user_name.text = item.user.username
    }
}


