package com.example.proyecto.Common

import Remote.RetrofitClient
import com.example.proyecto.Interface.NewsService

object Common {
    val BASE_URL = "https://newsapi.org"
    val API_KEY = "3619de0dd6594fe7974498bcaa91f269"

    val newsService: NewsService
    get() = RetrofitClient.getClient(BASE_URL).create(NewsService::class.java)

    fun getNewsAPI(source: String): String {
        val apiUrl = StringBuilder("https://newsapi.org/v2/top-headlines?country=ar")
            .append(source)
            .append("&apiKey=")
            .append(API_KEY)
            .toString()
        return apiUrl
    }
}