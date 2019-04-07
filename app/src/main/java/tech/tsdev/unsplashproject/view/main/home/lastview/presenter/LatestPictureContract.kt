package tech.tsdev.unsplashproject.view.main.home.lastview.presenter

interface LatestPictureContract {
    interface View {
        fun hideProgressbar()

        fun showProgressbar()

        fun showLoadFail()

        fun showLoadFail(message: String)
    }

    interface Presenter {
        fun loadImage()
    }
}