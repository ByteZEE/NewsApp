package com.rafi.core.di

import com.rafi.core.resources.remote.retrofit.ApiConfig
import com.rafi.core.resources.remote.retrofit.ApiService
import com.rafi.core.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder().baseUrl(Constant.Remote.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()

    @Provides
    @Singleton
    fun provideApiService(
        retrofit: Retrofit
    ): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(
        apiConfig: ApiConfig
    ) : OkHttpClient = OkHttpClient.Builder().build()
}