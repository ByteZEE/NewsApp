package com.rafi.core.util

import com.rafi.core.models.ArticleModel
import com.rafi.core.models.SourceModel
import com.rafi.core.resources.local.entity.ArticleEntity
import com.rafi.core.resources.local.entity.SourceEntity

object DataMapper {

    fun ArticleModel.toArticleEntity(): ArticleEntity =
        ArticleEntity(
            id,
            source.toSourceModel(),
            author,
            title,
            description,
            url,
            urlToImage,
            publishedAt,
            content
        )

    fun SourceModel.toSourceModel(): SourceEntity =
        SourceEntity(
            id,
            name
        )
}