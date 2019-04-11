package tech.tsdev.unsplashproject.data.source.image.mongodb

import retrofit2.Call
import tech.tsdev.unsplashproject.data.UserData


interface MongoDataSource {

    fun createUserWithEmail(email: String, password: String): Call<UserData>
}