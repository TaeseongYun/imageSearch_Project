package tech.tsdev.unsplashproject.view.main.home.detailsearch.presenter

interface DetailSearchContract {
    interface View {
        fun showFailmessage()

        fun showFailmessage(message: String)


        //recyclerViewModel부분 해당 포지션의 id 값 받아서 넘겨줌
        fun showBottomSheetDialog(positionId: String)


        //상단 app_bar 이름 띄우게 하는 fun
        fun loadSerachKeyword(searchKeyword: String)
    }

    interface Presenter{

        //검색한 키워드로 찾게 해주는 함수
        fun loadUnsplashImage(keyword: String)

    }
}