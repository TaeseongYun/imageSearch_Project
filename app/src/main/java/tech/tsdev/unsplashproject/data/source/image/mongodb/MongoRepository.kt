package tech.tsdev.unsplashproject.data.source.image.mongodb



object MongoRepository : MongoDataSource {

    private val mongodbRemoteData = MongoRemoteData()

    override fun createUserWithEmail(email: String, password: String)
            = mongodbRemoteData.createUserWithEmail(email, password)


}