package com.rafi.core.resources.remote.retrofit

import com.rafi.core.resources.remote.response.NewsResponse
import com.rafi.core.util.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country")
        countryCode: String = "id",

        @Query("page")
        pageNumber: Int = 1,

        @Query("apiKey")
        apiKey: String = Constant.Remote.API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun getSearch(
        @Query("q")
        searchQuery: String,

        @Query("page")
        pageNumber: Int = 1,

        @Query("apiKey")
        apiKey: String = Constant.Remote.API_KEY
    ): Response<NewsResponse>
}