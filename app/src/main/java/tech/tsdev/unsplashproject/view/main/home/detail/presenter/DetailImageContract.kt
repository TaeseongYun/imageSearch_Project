package tech.tsdev.unsplashproject.view.main.home.detail.presenter

interface DetailImageContract {
    interface View{
        fun updateToolbarItem(buddyIcon: String, buddyName: String)

        fun updateItem(imageUrl: String, description: String, favorite: Int, photos: Int)

        fun showLoadErrorToast()
    }

    interface Presenter {
//        해당 포지션 사진에 해당되는 id 값 받아와서 그 사진 정보를 BottomSheet에 뿌려줌
        fun loadDetailInfo(photoId: String)
    }
}