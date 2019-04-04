package tech.tsdev.unsplashproject.view.main.home.detailsearch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_search.*
import tech.tsdev.unsplashproject.R

class DetailSearch : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_search)

        detail_search_result.text = intent.getStringExtra("searchKeyword")
    }
}
