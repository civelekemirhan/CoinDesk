package com.example.coindesk.common.api

import com.example.coindesk.feature.main.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinDeskApi {


    @GET("/data/v2/news/")
    suspend fun getLatestNews(@Query("lang") lang: String): NewsResponse

    @GET("v1/bpi/currentprice.json")
    suspend fun getNewsByCategory(category: String): List<NewsResponse>

    @GET("v1/bpi/currentprice.json")
    suspend fun getNewsCategorys(): List<String>

    @GET("v1/bpi/currentprice.json")
    suspend fun getNewsByQuery(query: String): List<NewsResponse>


}