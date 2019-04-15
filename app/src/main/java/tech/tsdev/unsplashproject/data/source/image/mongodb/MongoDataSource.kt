package tech.tsdev.unsplashproject.data.source.image.mongodb

import retrofit2.Call
import tech.tsdev.unsplashproject.data.UserData


interface MongoDataSource {

    fun createUserWithEmail(name: String, email: String, password: String, correctPassword: String): Call<UserData>
}