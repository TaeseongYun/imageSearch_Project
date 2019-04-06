package tech.tsdev.unsplashproject.view.main.home.detailsearch.presenter

interface DetailSearchContract {
    interface View {
        fun showFailmessage()

        fun showFailmessage(message: String)

        fun showBottomSheetDialog(position: String)
    }

    interface Presenter{
        fun loadUnsplashImage(keyword: String)

    }
}