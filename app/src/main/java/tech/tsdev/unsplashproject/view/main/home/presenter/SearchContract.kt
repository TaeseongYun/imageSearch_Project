package tech.tsdev.unsplashproject.view.main.home.presenter

interface SearchContract {
    interface View {
        fun hideProgressbar()

        fun showProgressbar()
    }

    interface Presenter {
        fun loadImage()

    }
}