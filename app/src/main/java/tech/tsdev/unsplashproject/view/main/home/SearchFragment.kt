package tech.tsdev.unsplashproject.view.main.home


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_search.*
import tech.tsdev.unsplashproject.R
import tech.tsdev.unsplashproject.view.main.home.detailsearch.DetailSearch


class SearchFragment : Fragment() {

    companion object {
        val KEY_TITLE = "key-title"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_search, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if( s?.length?: 0 > 0) {
                    btn_search.visibility = View.VISIBLE
                } else {
                    btn_search.visibility = View.INVISIBLE
                }
            }

        })

        btn_search.setOnClickListener {
            startActivity(Intent(it.context, DetailSearch::class.java).apply {
                putExtra("searchKeyword", editText.text.toString())
            })
        }

    }
}