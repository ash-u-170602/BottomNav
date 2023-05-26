package com.example.bottomnav.NewsApi

import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey=180ee558b8a04d6d926acfc4b9cc2e59

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "180ee558b8a04d6d926acfc4b9cc2e59"

interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country: String, @Query("page") page: Int)

}