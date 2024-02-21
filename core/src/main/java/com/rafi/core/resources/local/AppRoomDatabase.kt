package com.rafi.core.resources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rafi.core.resources.local.dao.ArticleDao
import com.rafi.core.resources.local.entity.ArticleEntity

@Database(
    entities = [ArticleEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}