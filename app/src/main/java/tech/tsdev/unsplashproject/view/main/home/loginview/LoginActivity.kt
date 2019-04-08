package tech.tsdev.unsplashproject.view.main.home.loginview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import tech.tsdev.unsplashproject.R
import tech.tsdev.unsplashproject.view.main.home.loginview.presenter.LoginContract
import tech.tsdev.unsplashproject.view.main.home.loginview.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), LoginContract.View {


    override fun showProgressBar() {
        progress_Bar.visibility = View.VISIBLE
    }

    override fun dismissProgrssBar() {
        progress_Bar.visibility = View.INVISIBLE
    }

    override fun loginFailMessage() {
        Toast.makeText(this@LoginActivity, "없는 아이디거나 패스워드가 틀립니다.", Toast.LENGTH_SHORT).show()
    }

    override fun loginFailMessage(message: String) {
        Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()
    }

    private val loginPresenter: LoginPresenter by lazy {
        LoginPresenter(this@LoginActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        progress_Bar.visibility = View.INVISIBLE


        img_close_btn.setOnClickListener {
            finish()
        }

        btn_login.setOnClickListener {
            loginPresenter.loginEmailAndPassword(tv_user_id.text.toString(), tv_user_pw.text.toString())
        }

    }
}
