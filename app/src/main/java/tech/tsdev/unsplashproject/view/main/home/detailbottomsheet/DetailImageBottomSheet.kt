package tech.tsdev.unsplashproject.view.main.home.detailbottomsheet

import android.app.Dialog
import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.bottom_sheet_detail.*
import tech.tsdev.unsplashproject.R
import tech.tsdev.unsplashproject.data.source.image.unsplash.UnsplashRepository
import tech.tsdev.unsplashproject.view.main.home.detailbottomsheet.presenter.DetailImageContract
import tech.tsdev.unsplashproject.view.main.home.detailbottomsheet.presenter.DetailImagePresenter

class DetailImageBottomSheet : BottomSheetDialogFragment(), DetailImageContract.View {
    private  var mDownloadReference: Long = 0L
    private lateinit var mDownloadManager: DownloadManager


    override fun downloadImage(url: String?) {
        mDownloadManager = context?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val uri = Uri.parse(url)
        val request = DownloadManager.Request(uri)
            .apply {
                setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE)
                setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
                setVisibleInDownloadsUi(true)
                setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, uri.lastPathSegment)
            }
        mDownloadReference = mDownloadManager.enqueue(request)
    }

    override fun showDownloadSuccess() {
        Toast.makeText(context, "사진 다운로드 완료", Toast.LENGTH_SHORT).show()
    }

    override fun showLoadErrorToast() {
        Toast.makeText(context, "에러입니다", Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val KEY_PHOTO_ID = "key-photo-id"

        fun create(photoId: String): DetailImageBottomSheet
                = DetailImageBottomSheet().apply {
            arguments = Bundle().apply {
                putString(KEY_PHOTO_ID, photoId)
            }
        }
    }

    private val detailImagePresenter: DetailImagePresenter by lazy {
        DetailImagePresenter(this@DetailImageBottomSheet, UnsplashRepository)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener {
            val bottomSheet = dialog.findViewById<View>(android.support.design.R.id.design_bottom_sheet)
            BottomSheetBehavior.from(bottomSheet).apply {
                state = BottomSheetBehavior.STATE_EXPANDED
                peekHeight = 30
                setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){
                    override fun onSlide(p0: View, p1: Float) {

                    }

                    override fun onStateChanged(p0: View, newState: Int) {
                        when(newState) {
                            BottomSheetBehavior.STATE_COLLAPSED -> {
                                if( !isRemoving ) dismiss()
                            }else -> {

                        }
                        }
                    }

                })
            }
        }
        return dialog
    }

    private fun updateToolbarVisibility() {
        when(app_bar.visibility) {
            View.VISIBLE -> {
                app_bar.visibility = View.INVISIBLE
                view_content_container.visibility = View.INVISIBLE
                view?.systemUiVisibility = View.SYSTEM_UI_FLAG_LOW_PROFILE
            }
            else -> {
                app_bar.visibility = View.VISIBLE
                view_content_container.visibility = View.VISIBLE
                view?.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
            }
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = View.inflate(context, R.layout.bottom_sheet_detail, null)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        img.setOnClickListener {
            updateToolbarVisibility()
        }
        img_close_btn.setOnClickListener {
            dismiss()
        }
        img_web.setOnClickListener {

        }

        floating_action_button.setOnClickListener {
            arguments?.getString(KEY_PHOTO_ID)?.let { detailImagePresenter.imageDownload(it) }
        }

        arguments?.getString(KEY_PHOTO_ID)?.let { detailImagePresenter.loadDetailInfo(it) }
    }
    override fun updateToolbarItem(buddyIcon: String, buddyName: String) {
        img_owner_image.loadImage(buddyIcon)

        tv_owner_name.text = buddyName
    }

    override fun updateItem(imageUrl: String, description: String, favorite: Int, photos: Int) {
        img.loadImage(imageUrl)
        tv_description.text = description
        tv_favorite.text = favorite.toString()
        tv_photos_library.text = photos.toString()
    }

}