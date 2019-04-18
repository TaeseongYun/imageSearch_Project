package tech.tsdev.unsplashproject.util

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import java.util.*

fun AppCompatActivity.replace(@IdRes frameId: Int, fragment: Fragment, tag: String? = null)
        = supportFragmentManager.beginTransaction().replace(frameId, fragment, tag).commitAllowingStateLoss()

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start)