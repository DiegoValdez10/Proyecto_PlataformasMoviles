package com.example.proyecto.Interface

import com.example.proyecto.Model.News
import com.example.proyecto.Model.WebSite
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface NewsService {
    @get: GET("v2/sources?apikey=3619de0dd6594fe7974498bcaa91f269")
    val sources: Call<WebSite>

    @GET
    fun getNewsFromSource(@Url url:String): Call<News>
}