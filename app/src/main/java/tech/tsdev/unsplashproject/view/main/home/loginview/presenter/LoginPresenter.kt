package tech.tsdev.unsplashproject.view.main.home.loginview.presenter


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.tsdev.unsplashproject.data.UserData
import tech.tsdev.unsplashproject.data.source.image.mongodb.MongoRepository

class LoginPresenter(val view: LoginContract.View,
                     private val mongoRepository: MongoRepository) : LoginContract.Presenter {


    override fun createUser(name: String, email: String, password: String, correctPassword: String) {
        view.showProgressBar()
        mongoRepository.createUserWithEmail(name, email, password, correctPassword).enqueue(object : Callback<UserData>{
            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                if(response.isSuccessful) {

                    //어떤 이유인지는 모르겠는데 db 에는 값이 들어가는데 실패 했다고 넘어감 그래서
                    // Failure에 프로그래스 바 사라지는 코드 넣어 주었음 여기엔 오류 메세지 띄우는 코드
                    view.loginFailMessage()
                }
            }

            override fun onFailure(call: Call<UserData>, t: Throwable) {
                view.dismissProgrssBar()
            }

        })
    }


}