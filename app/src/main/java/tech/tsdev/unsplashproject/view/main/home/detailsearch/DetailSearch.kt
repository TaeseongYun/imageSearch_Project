package tech.tsdev.unsplashproject.view.main.home.detailsearch


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail_search.*
import tech.tsdev.unsplashproject.R
import tech.tsdev.unsplashproject.data.source.image.unsplash.UnsplashRepository
import tech.tsdev.unsplashproject.view.main.home.detailbottomsheet.DetailImageBottomSheet
import tech.tsdev.unsplashproject.view.main.home.detailsearch.adapter.DetailImageRecyclerAdapter
import tech.tsdev.unsplashproject.view.main.home.detailsearch.presenter.DetailSearchContract
import tech.tsdev.unsplashproject.view.main.home.detailsearch.presenter.DetailSearchPresenter

class DetailSearch : AppCompatActivity(), DetailSearchContract.View {
    override fun loadSerachKeyword(searchKeyword: String) {
        tv_search_keyword.text = searchKeyword
    }

    override fun showBottomSheetDialog(positionId: String) {
        if (isDestroyed) return

        DetailImageBottomSheet.create(positionId).show(this.supportFragmentManager, "DetailImageBottomSheet")
    }


    override fun showFailmessage() {
        if (isDestroyed) return

        Toast.makeText(this, "Load Fail", Toast.LENGTH_SHORT).show()
    }

    override fun showFailmessage(message: String) {
        if (isDestroyed) return

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private val detailImageRecyclerAdapter: DetailImageRecyclerAdapter by lazy {
        DetailImageRecyclerAdapter(this)
    }

    private val detailSearchPresenter: DetailSearchPresenter by lazy {
        DetailSearchPresenter(this, UnsplashRepository, detailImageRecyclerAdapter)
    }

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val visibleItem = recyclerView.childCount
            val totalItemCount = detailImageRecyclerAdapter.itemCount
            val firstVisibleItem =
                (recyclerView.layoutManager as? GridLayoutManager)?.findFirstVisibleItemPosition() ?: 0

            if (!detailSearchPresenter.isLoading && (firstVisibleItem - visibleItem) >= totalItemCount - 18) {
                detailSearchPresenter.loadUnsplashImage(intent.getStringExtra("searchKeyword"))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_search)


        detailSearchPresenter.loadUnsplashImage(intent.getStringExtra("searchKeyword"))


        //app_bar 키워드 띄워주는 함수
        loadSerachKeyword(intent.getStringExtra("searchKeyword"))

        img_search_close_btn.setOnClickListener {
            finish()
        }

        recycler_view_detail.run {
            adapter = detailImageRecyclerAdapter
            layoutManager = GridLayoutManager(this@DetailSearch, 1)
            addOnScrollListener(recyclerViewOnScrollListener)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        recycler_view_detail?.removeOnScrollListener(recyclerViewOnScrollListener)
    }
}
