package com.rafi.core.util

import com.rafi.core.BuildConfig

object Constant {

    object Remote {
        const val BASE_URL = BuildConfig.BASE_URL
        const val API_KEY = BuildConfig.API_KEY
    }

    object News {
        const val SEARCH_NEWS_TIME_DELAY = "500L"
        const val QUERY_PAGE_SIZE = "20"
    }

    object Room {
        const val DATABASE_NAME = "app_room_database"
    }
}