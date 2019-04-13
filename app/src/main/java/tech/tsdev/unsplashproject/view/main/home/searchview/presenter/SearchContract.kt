package tech.tsdev.unsplashproject.view.main.home.searchview.presenter

interface SearchContract {

    interface View {
        fun showBottomSheetDialog(id: String)

        fun showFailmessage(message: String)

        fun showFailmessage()

    }
    interface Presenter {

        fun loadKeywordImg(keyword: String)
    }
}