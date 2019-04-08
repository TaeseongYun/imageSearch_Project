package tech.tsdev.unsplashproject.view.main.home.loginview.presenter

import com.google.firebase.auth.FirebaseAuth

class LoginPresenter(val view: LoginContract.View) : LoginContract.Presenter {

    private var auth = FirebaseAuth.getInstance()

    override fun loginEmailAndPassword(userId: String, userPassword: String) {
        view.showProgressBar()
        println("userId: $userId  userPs: $userPassword")
        auth.createUserWithEmailAndPassword(userId, userPassword).addOnCompleteListener {
                task -> if(task.isSuccessful){
            view.dismissProgrssBar()
        }
        }.addOnFailureListener { view.loginFailMessage() }
    }

    override fun loginWithFacebook() {

    }

}