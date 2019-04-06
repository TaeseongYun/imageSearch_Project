package tech.tsdev.unsplashproject.view.main.home.presenter

interface SearchContract {
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