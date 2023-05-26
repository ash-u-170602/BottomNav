package com.example.bottomnav.NewsApi.modalClasses

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)