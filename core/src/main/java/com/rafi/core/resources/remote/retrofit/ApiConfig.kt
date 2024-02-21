package com.rafi.core.resources.remote.retrofit

import android.content.Context
import com.rafi.core.util.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiConfig @Inject constructor(
    private val context: Context
) {
    private val apiService: ApiService by lazy {
        val okHttpClient = OkHttpClient.Builder().build()

        val retrofit = Retrofit.Builder().baseUrl(Constant.Remote.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()

        val apiService = retrofit.create(ApiService::class.java)

        apiService
    }
}