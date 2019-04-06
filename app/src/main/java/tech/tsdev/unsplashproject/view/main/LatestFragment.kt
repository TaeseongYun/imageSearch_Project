package tech.tsdev.unsplashproject.view.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_picture.*
import tech.tsdev.unsplashproject.R
import tech.tsdev.unsplashproject.data.source.image.unsplash.UnsplashRepository
import tech.tsdev.unsplashproject.view.main.home.adapter.ImageRecyclerAdapter
import tech.tsdev.unsplashproject.view.main.home.presenter.SearchContract
import tech.tsdev.unsplashproject.view.main.home.presenter.SearchPresenter


class LatestFragment : Fragment(), SearchContract.View {
    override fun showLoadFail() {
        if( isDetached )  return


        Toast.makeText(context, "Load-Fail", Toast.LENGTH_SHORT).show()
    }

    override fun showLoadFail(message: String) {
        if( isDetached )  return

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
    private val searchPresenter: SearchPresenter by lazy {
        SearchPresenter(this@LatestFragment,
            UnsplashRepository,
            imageRecyclerAdapter)
    }

    private val imageRecyclerAdapter: ImageRecyclerAdapter by lazy {
        ImageRecyclerAdapter(this@LatestFragment.context)
    }

    override fun hideProgressbar() {
        progressBar.visibility = View.GONE
    }

    override fun showProgressbar() {
        progressBar.visibility = View.VISIBLE
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
}

