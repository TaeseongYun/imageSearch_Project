package tech.tsdev.unsplashproject.data.source.image.mongodb

import tech.tsdev.unsplashproject.data.UserData
import tech.tsdev.unsplashproject.network.MongoDBInterface
import tech.tsdev.unsplashproject.network.createRetrofit


class MongoRemoteData : MongoDataSource {

    companion object {
        const val MONGODB_CONNET = "http://10.0.2.2:5000"
    }

    private val mongodbMakeUser = createRetrofit(MongoDBInterface::class.java, MONGODB_CONNET)

    override fun createUserWithEmail(name: String, email: String, password: String, correctPassword: String)
            = mongodbMakeUser.makeUserWithEmail(UserData(name, email, password, correctPassword))


}