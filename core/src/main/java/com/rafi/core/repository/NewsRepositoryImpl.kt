package com.rafi.core.repository

import com.rafi.core.models.ArticleModel
import com.rafi.core.resources.local.dao.ArticleDao
import com.rafi.core.resources.remote.retrofit.ApiService
import com.rafi.core.util.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val articleDao: ArticleDao
) : NewsRepository {
    override fun searchArticle(query: String): Flow<ResultState<List<String>>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertFavorite(articleId: ArticleModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFavorite(articleId: ArticleModel) {
        TODO("Not yet implemented")
    }

}