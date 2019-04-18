package tech.tsdev.unsplashproject.view.main.home.randomview

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_random.*
import tech.tsdev.unsplashproject.R
import tech.tsdev.unsplashproject.data.source.image.unsplash.UnsplashRepository
import tech.tsdev.unsplashproject.view.main.home.detailbottomsheet.DetailImageBottomSheet
import tech.tsdev.unsplashproject.view.main.home.randomview.adapter.RandomPictureAdapater
import tech.tsdev.unsplashproject.view.main.home.randomview.presenter.RandomPictureContract
import tech.tsdev.unsplashproject.view.main.home.randomview.presenter.RandomPicturePresenter
import java.lang.Exception

class RandomPictureFragment : Fragment(), RandomPictureContract.View {

    private val randomPicturePresenter: RandomPicturePresenter by lazy {
        RandomPicturePresenter(
            this@RandomPictureFragment,
            randomRecyclerViewAdapter,
            UnsplashRepository
        )
    }
    private val randomRecyclerViewAdapter: RandomPictureAdapater by lazy {
        RandomPictureAdapater(this@RandomPictureFragment.context)
    }

    override fun showProgressbar() {
        progress_bar_layout.visibility = View.VISIBLE
    }

    override fun dismissProgressbar() {
        progress_bar_layout.visibility = View.GONE
    }

    override fun showErrorMessage() {
        Toast.makeText(context, "Load Fail", Toast.LENGTH_SHORT).show()
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showBottomSheet(photoId: String) {
        if (isDetached) return

        DetailImageBottomSheet.create(photoId).show(this.fragmentManager, "DetailImageBottomSheet")
    }

    override fun onDestroyView() {
        super.onDestroyView()

        recycler_view_random.removeOnScrollListener(recyclerViewScrollListener)

    }

    private val recyclerViewScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val totalItemCount = randomRecyclerViewAdapter.itemCount
            val visibleItemCount = recyclerView.childCount
            val firstVisibleItem =
                (recyclerView.layoutManager as? GridLayoutManager)?.findFirstVisibleItemPosition() ?: 0

            if (!randomPicturePresenter.isLoading && (firstVisibleItem + visibleItemCount) >= totalItemCount - 7) {
                randomPicturePresenter.loadRandomImage()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_random, container, false)

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        randomPicturePresenter.loadRandomImage()

        recycler_view_random.run {
            adapter = randomRecyclerViewAdapter
            layoutManager = GridLayoutManager(this@RandomPictureFragment.context, 1)
            addOnScrollListener(recyclerViewScrollListener)
        }



        swipe_refresh_layout.setOnRefreshListener {
            randomRecyclerViewAdapter.removeItem()
            randomPicturePresenter.loadRandomImage()

            swipe_refresh_layout.setColorSchemeColors(R.color.black)
            swipe_refresh_layout.isRefreshing = false
        }
    }
}