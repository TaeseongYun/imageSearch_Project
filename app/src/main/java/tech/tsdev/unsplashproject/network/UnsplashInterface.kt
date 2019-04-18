package tech.tsdev.unsplashproject.network


import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import tech.tsdev.unsplashproject.data.*


interface  UnsplashInterface {

    //검색으로 사진찾는 쿼리(사진은 랜덤)
    @GET("/photos/random?client_id=50fda0b295b432b006dc70b08f3ca128a32efa16f92cec67d97cb41d559d3ff1")
    fun getUnsplashSearchPhotos(
        @Query("query") query: String,
        @Query("count") page: Int
    ): Call<List<RandomSearchPhoto>>



    //Path값 주고 {Path} Get 넣어주면 매번 바뀐다
    //클릭 하였을 때 해당 유저 이름의 사진 불러오기 위한 쿼리
    @GET("{username}?client_id=YOUR_ACCESS_KEY")
    fun getDetailInfo(
        @Path("username") username: String
    ): Call<SinglePhoto>


    //최근 사진 불러오게 하는 쿼리
    @GET("?client_id=YOUR_ACCESS_KEY")
    fun getUpsplashLatestPhotos(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): Call<List<LatestPhotos>>

    //사진 다운로드 하게 하는 쿼리
    @GET("{userId}/download?client_id=YOUR_ACCESS_KEY")
    fun getDownloadImage(
        @Path("userId") userId: String
    ): Call<JSONObject>

    @GET("photos/random?client_id=YOUR_ACCESS_KEY")
    fun getRandomPhoto(
        @Query("count") count: Int
    ): Call<List<RandomPhoto>>
}