package tech.tsdev.unsplashproject.network

import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url
import tech.tsdev.unsplashproject.data.Download
import tech.tsdev.unsplashproject.data.LatestPhotos
import tech.tsdev.unsplashproject.data.PhotosResponse
import tech.tsdev.unsplashproject.data.SinglePhoto


interface  UnsplashInterface {

    //검색으로 사진찾는 쿼리
    @GET("?client_id=YOUR_ACCESS_KEY")
    fun getUnsplashSearchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): Call<PhotosResponse>



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
}