package tech.tsdev.unsplashproject.view.main

import android.app.Dialog
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*
import tech.tsdev.unsplashproject.R
import tech.tsdev.unsplashproject.util.replace
import tech.tsdev.unsplashproject.view.main.home.SearchFragment
import tech.tsdev.unsplashproject.view.main.home.lastview.LatestPictureFragment
import tech.tsdev.unsplashproject.view.main.home.loginview.LoginActivity
import tech.tsdev.unsplashproject.view.main.home.searchview.SearchActivity
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
            R.id.navigation_random -> {
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
    private val permissionListener = object: PermissionListener {
        override fun onPermissionGranted() {
            Toast.makeText(this@MainActivity, "권한 허가",  Toast.LENGTH_SHORT).show()
        }

        override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
            finish()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        replace(R.id.frameLayout, latestFragment)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        TedPermission.with(this)
            .setPermissionListener(permissionListener)
            .setRationaleTitle(R.string.not_grant_permission)
            .setRationaleMessage(R.string.need_permision)
            .setPermissions(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                , android.Manifest.permission.READ_EXTERNAL_STORAGE)
            .check()

        img_user.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        btn_search.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }
    }


}
