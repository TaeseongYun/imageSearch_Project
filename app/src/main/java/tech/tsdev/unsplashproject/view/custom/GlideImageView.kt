package tech.tsdev.unsplashproject.view.custom

import android.content.Context
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import tech.tsdev.unsplashproject.R


class GlideImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ImageView(context, attrs, defStyleAttr) {

    fun loadImage(url: String, @DrawableRes loadingImageRes: Int = R.drawable.bg_gradtion) {
        Glide.with(this)
            .load(url)
            .apply( RequestOptions.placeholderOf(loadingImageRes).centerCrop() )
            .into(this)
    }

    fun loadProfileImage(url: String, @DrawableRes loadingImageRes: Int = R.drawable.bg_gradtion) {
        Glide.with(this)
            .load(url)
            .apply( RequestOptions.placeholderOf(loadingImageRes).circleCrop() )
            .into(this)
    }
}