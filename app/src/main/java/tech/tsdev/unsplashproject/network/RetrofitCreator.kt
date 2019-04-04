package tech.tsdev.unsplashproject.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

fun <T> createRetrofit(cls: Class<T>, baseUrl: String): T {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory( GsonConverterFactory.create() )

        .client( createOkHttpClient() )
        .build()
        .create(cls)
}

private fun createOkHttpClient() : OkHttpClient {
    val builder = OkHttpClient.Builder()

    builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    return builder.build()
}