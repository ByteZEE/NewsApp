package com.rafi.core.repository

import com.rafi.core.models.ArticleModel
import com.rafi.core.util.ResultState
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun searchArticle(query: String): Flow<ResultState<List<String>>>
    suspend fun insertFavorite(articleId: ArticleModel)
    suspend fun deleteFavorite(articleId: ArticleModel)
}