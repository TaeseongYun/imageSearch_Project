package tech.tsdev.unsplashproject.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import tech.tsdev.unsplashproject.data.UserData

interface MongoDBInterface {
    @POST("/register")
    fun makeUserWithEmail(
        @Body user: UserData
    ): Call<UserData>
}