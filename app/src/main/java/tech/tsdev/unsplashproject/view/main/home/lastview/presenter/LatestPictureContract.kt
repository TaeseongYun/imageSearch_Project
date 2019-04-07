package tech.tsdev.unsplashproject.view.main.home.lastview.presenter

interface LatestPictureContract {
    interface View {
        fun hideProgressbar()

        fun showProgressbar()

        fun showLoadFail()

        fun showLoadFail(message: String)

        fun showBottomSheetDialog(positionId: String)
    }

    interface Presenter {
        fun loadImage()
    }
}