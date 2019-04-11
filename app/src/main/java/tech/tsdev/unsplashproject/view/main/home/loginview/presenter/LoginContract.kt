package tech.tsdev.unsplashproject.view.main.home.loginview.presenter


import retrofit2.Call
import tech.tsdev.unsplashproject.data.UserData

interface LoginContract {
    interface View{
        fun loginFailMessage()

        fun loginFailMessage(message: String)

        fun showProgressBar()

        fun dismissProgrssBar()
    }

    interface Presenter{
       fun createUser(email: String, password: String)
    }
}