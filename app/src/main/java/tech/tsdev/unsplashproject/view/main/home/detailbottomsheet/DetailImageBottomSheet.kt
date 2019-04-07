package tech.tsdev.unsplashproject.view.main.home.detailbottomsheet

import android.app.Dialog
import android.os.Bundle
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
            println("다운로드 버튼 클릭됬습니다.")
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