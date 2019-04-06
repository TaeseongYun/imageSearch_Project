package tech.tsdev.unsplashproject.view.main.home.detailsearch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail_search.*
import tech.tsdev.unsplashproject.R
import tech.tsdev.unsplashproject.data.source.image.unsplash.UnsplashRepository
import tech.tsdev.unsplashproject.view.main.home.adapter.ImageRecyclerAdapter
import tech.tsdev.unsplashproject.view.main.home.detailsearch.presenter.DetailSearchContract
import tech.tsdev.unsplashproject.view.main.home.detailsearch.presenter.DetailSearchPresenter

class DetailSearch : AppCompatActivity(), DetailSearchContract.View {
    override fun showFailmessage() {
        if ( isDestroyed ) return

        Toast.makeText(this, "Load Fail", Toast.LENGTH_SHORT).show()
    }

    override fun showFailmessage(message: String) {
        if ( isDestroyed ) return

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private val imageRecyclerAdapter: ImageRecyclerAdapter by lazy {
        ImageRecyclerAdapter(this)
    }

    private val detailSearchPresenter: DetailSearchPresenter by lazy {
        DetailSearchPresenter(this, UnsplashRepository, imageRecyclerAdapter)
    }

    private val recyclerViewOnScrollListener = object: RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val visibleItem = recyclerView.childCount as Int
            val totalItemCount = imageRecyclerAdapter.itemCount
            val firstVisibleItem = (recyclerView.layoutManager as? GridLayoutManager)?.findFirstVisibleItemPosition() ?: 0

            if(!detailSearchPresenter.isLoading && (firstVisibleItem - visibleItem) >= totalItemCount - 3) {
                detailSearchPresenter.loadUnsplashImage(intent.getStringExtra("searchKeyword"))
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_search)

        detailSearchPresenter.loadUnsplashImage(intent.getStringExtra("searchKeyword"))

        recycler_view_detail.run {
            adapter = imageRecyclerAdapter
            layoutManager = GridLayoutManager(this@DetailSearch, 3)
            addOnScrollListener(recyclerViewOnScrollListener)
        }
    }
}
