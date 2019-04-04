package tech.tsdev.unsplashproject.view.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_picture.*
import tech.tsdev.unsplashproject.R
import tech.tsdev.unsplashproject.data.source.image.ImageRepository
import tech.tsdev.unsplashproject.view.main.home.adapter.ImageRecyclerAdapter
import tech.tsdev.unsplashproject.view.main.home.presenter.SearchContract
import tech.tsdev.unsplashproject.view.main.home.presenter.SearchPresenter

class LatestFragment : Fragment(), SearchContract.View {
    private val searchPresenter: SearchPresenter by lazy {
        SearchPresenter(this@LatestFragment, ImageRepository, imageRecyclerAdapter)
    }

    private val imageRecyclerAdapter: ImageRecyclerAdapter by lazy {
        ImageRecyclerAdapter(this@LatestFragment.context!!)
    }
    override fun hideProgressbar() {
        progressBar.visibility = View.GONE
    }

    override fun showProgressbar() {
        progressBar.visibility = View.VISIBLE
    }

    companion object {
        val KEY_TITLE = "key-title"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        recycler_view?.removeOnScrollListener(recyclerViewOnScrollListener)
    }

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val visibleItemCount = recyclerView.childCount as Int
            val totalItemCount = imageRecyclerAdapter.itemCount
            val firstVisibleItem = (recyclerView.layoutManager as? GridLayoutManager)?.findFirstVisibleItemPosition() ?: 0

            if (!searchPresenter.isLoading && (firstVisibleItem + visibleItemCount) >= totalItemCount - 7) {
                searchPresenter.loadImage()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_picture, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchPresenter.loadImage()

        recycler_view.run {
            adapter = imageRecyclerAdapter
            layoutManager = GridLayoutManager(this@LatestFragment.context, 3)
            addOnScrollListener(recyclerViewOnScrollListener)
        }
    }

    override fun onStop() {
        super.onStop()


    }
}

