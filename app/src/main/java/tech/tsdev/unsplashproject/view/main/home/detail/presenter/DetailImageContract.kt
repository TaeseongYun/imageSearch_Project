package tech.tsdev.unsplashproject.view.main.home.detail.presenter

interface DetailImageContract {
    interface View{
        fun updateToolbarItem(buddyIcon: String, buddyName: String)

        fun updateItem(imageUrl: String, description: String, favorite: Int, photos: Int)

        fun showLoadErrorToast()
    }

    interface Presenter {
        fun loadDetailInfo(photoId: String)
    }
}