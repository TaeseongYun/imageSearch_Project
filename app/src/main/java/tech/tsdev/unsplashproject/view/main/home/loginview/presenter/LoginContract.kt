package tech.tsdev.unsplashproject.view.main.home.loginview.presenter

import com.google.firebase.auth.FirebaseAuth

interface LoginContract {
    interface View{
        fun loginFailMessage()

        fun loginFailMessage(message: String)

        fun showProgressBar()

        fun dismissProgrssBar()
    }

    interface Presenter{
        fun loginEmailAndPassword(userId: String, userPassword: String)

        fun loginWithFacebook()
    }
}