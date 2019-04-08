package tech.tsdev.unsplashproject.network

interface FirebaseInterface {
    fun loginEmailAndPassword(userId: String, userPassword: String)
}