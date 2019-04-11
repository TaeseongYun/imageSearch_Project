package tech.tsdev.unsplashproject.data.source.image.mongodb

import tech.tsdev.unsplashproject.data.UserData
import tech.tsdev.unsplashproject.network.MongoDBInterface
import tech.tsdev.unsplashproject.network.createRetrofit


class MongoRemoteData : MongoDataSource {

    companion object {
        const val MONGODB_CONNET = "http://10.0.2.2:3000"
    }

    private val mongodbMakeUser = createRetrofit(MongoDBInterface::class.java, MONGODB_CONNET)

    override fun createUserWithEmail(email: String, password: String)
            = mongodbMakeUser.makeUserWithEmail(UserData(email, password))


}