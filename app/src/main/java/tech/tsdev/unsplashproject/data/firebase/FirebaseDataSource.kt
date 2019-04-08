package tech.tsdev.unsplashproject.data.firebase

interface FirebaseDataSource {
    fun loginEmailAndPassword(userId: String, userPassword: String)
}