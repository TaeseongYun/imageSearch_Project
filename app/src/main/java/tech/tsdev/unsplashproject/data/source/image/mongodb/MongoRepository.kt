package tech.tsdev.unsplashproject.data.source.image.mongodb



object MongoRepository : MongoDataSource {

    private val mongodbRemoteData = MongoRemoteData()

    override fun createUserWithEmail(name: String, email: String, password: String, correctPassword: String)
            = mongodbRemoteData.createUserWithEmail(name, email, password, correctPassword)


}