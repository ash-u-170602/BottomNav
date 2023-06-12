package com.example.bottomnav.NewsApi

import com.example.bottomnav.NewsApi.modalClasses.News
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "180ee558b8a04d6d926acfc4b9cc2e59"

//https://newsapi.org/v2/top-headlines?apiKey=180ee558b8a04d6d926acfc4b9cc2e59&country=ca&page=1
interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    suspend fun getHeadlines(
        @Query("country") country: String,
        @Query("page") page: Int
    ): Response<News>

}


object NewsService {
    val newsInstance: NewsInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}