package tech.tsdev.unsplashproject.view.main.home.searchview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_search.*
import tech.tsdev.unsplashproject.R

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)


        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.let {
                    if(s.isEmpty()) {

                    }
                }
            }

        })
        searchProgressI.animation = AnimationUtils.loadAnimation(this, R.anim.rotation_progress)
    }
}
