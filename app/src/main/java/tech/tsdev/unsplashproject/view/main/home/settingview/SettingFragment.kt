package tech.tsdev.unsplashproject.view.main.home.settingview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_ect.*
import tech.tsdev.unsplashproject.R

class SettingFragment : Fragment() {

    companion object {
        val KEY_TITLE = "key-title"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_ect, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView.setText(arguments?.getInt(KEY_TITLE) ?: 0)
    }
}