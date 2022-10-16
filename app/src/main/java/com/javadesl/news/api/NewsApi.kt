package com.javadesl.news.api

import com.javadesl.news.data.news.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsApi {

    companion object {
        const val BASE_URL = "https://us.mahdi-saberi.ir/"
        const val CLIENT_ID = "961304:63468a8012a1c8.42537746"
    }

    @GET("napi/photos/${CLIENT_ID}/{action}")
    suspend fun getNews(
        @Path("action") action: String
    ): Response<News>

}