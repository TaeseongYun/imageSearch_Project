package tech.tsdev.unsplashproject.view.main.home.randomview.presenter

interface RandomPictureContract {
    interface View{
        fun showProgressbar()

        fun dismissProgressbar()

        fun showErrorMessage()

        fun showErrorMessage(message: String)

        fun showBottomSheet(photoId: String)
    }

    interface Presenter {
        fun loadRandomImage()
    }
}