package tech.tsdev.unsplashproject.view.main.home.detailsearch.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tech.tsdev.unsplashproject.data.Result
import tech.tsdev.unsplashproject.view.main.home.detailsearch.adapter.holder.DetailRecyclerHolder
import tech.tsdev.unsplashproject.view.main.home.detailsearch.adapter.model.DetailRecyclerModel

class DetailImageRecyclerAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
    , DetailRecyclerModel {



    override lateinit var onClick: (Int) -> Unit
    private val list = mutableListOf<Result>()



    override fun addItem(imageData: Result) {
        list.add(imageData)
    }

    override fun getItem(position: Int): Result = list[position]

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder{
        return DetailRecyclerHolder(onClick, context, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? DetailRecyclerHolder)?.onBind(list[position])
    }

    override fun notifyDataChange() {
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

}