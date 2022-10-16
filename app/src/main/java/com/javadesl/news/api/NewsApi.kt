package com.javadesl.news.api

import com.javadesl.news.data.news.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApi {

    companion object {
        const val BASE_URL = "https://one-api.ir/"
        const val CLIENT_ID = "961304:63468a8012a1c8.42537746"
    }

    @GET("rss")
    suspend fun getNews(
        @Query("action") action: String,
        @Query("token") token: String = CLIENT_ID,
    ): News

}