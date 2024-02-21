package com.rafi.core.di

import android.content.Context
import androidx.room.Room
import com.rafi.core.repository.NewsRepository
import com.rafi.core.repository.NewsRepositoryImpl
import com.rafi.core.resources.local.AppRoomDatabase
import com.rafi.core.resources.local.dao.ArticleDao
import com.rafi.core.resources.remote.retrofit.ApiConfig
import com.rafi.core.resources.remote.retrofit.ApiService
import com.rafi.core.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    @Singleton
    fun provideAppRoomDatabase(
        @ApplicationContext context: Context
    ): AppRoomDatabase = Room.databaseBuilder(
        context,
        AppRoomDatabase::class.java,
        Constant.Room.DATABASE_NAME
    ).allowMainThreadQueries().build()

    @Provides
    @Singleton
    fun provideArticleDao(appRoomDatabase: AppRoomDatabase): ArticleDao = appRoomDatabase
        .articleDao()

    @Provides
    @Singleton
    fun provideNewsRepository(
        apiService: ApiService,
        articleDao: ArticleDao
    ): NewsRepository = NewsRepositoryImpl(apiService, articleDao)
}