package tech.tsdev.unsplashproject.view.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import tech.tsdev.unsplashproject.R
import tech.tsdev.unsplashproject.util.replace
import tech.tsdev.unsplashproject.view.main.home.SearchFragment
import tech.tsdev.unsplashproject.view.main.home.lastview.LatestPictureFragment
import tech.tsdev.unsplashproject.view.main.home.settingview.SettingFragment

class MainActivity : AppCompatActivity() {

    private val searchFragment: SearchFragment by lazy {
        SearchFragment()
    }
    private val latestFragment: LatestPictureFragment by lazy {
        LatestPictureFragment()
    }

    private val settingFragment: SettingFragment by lazy {
        SettingFragment().apply {
            arguments = Bundle().apply {
                putInt(SettingFragment.KEY_TITLE, R.string.title_setting)
            }
        }
    }
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_search -> {
                replace(R.id.frameLayout, searchFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_latest_picture -> {
                replace(R.id.frameLayout, latestFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_setting -> {
                replace(R.id.frameLayout, settingFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        replace(R.id.frameLayout, searchFragment)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
