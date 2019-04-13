package tech.tsdev.unsplashproject.view.main.home.searchview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tech.tsdev.unsplashproject.data.Result
import tech.tsdev.unsplashproject.view.main.home.searchview.adapter.holder.SearchRecyclerHolder
import tech.tsdev.unsplashproject.view.main.home.searchview.adapter.model.SearchRecyclerModel

class SearchRecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), SearchRecyclerModel {

    override lateinit var onClick: (Int) -> Unit
    val list = mutableListOf<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return SearchRecyclerHolder(onClick, context, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, position: Int) {
        (p0 as SearchRecyclerHolder).onBind(list[position])
    }

    override fun addItem(item: Result) {
        list.add(item)
    }

    override fun notifyDatachange() {
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Result = list[position]
}