package com.example.anime.retrofit

import com.example.anime.models.AnimeInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApi {
    @GET("anime")
    suspend fun getAnimeList(
        @Query("q") query: String,
        @Query("sfw") sfw: Boolean = true
    ): Response<AnimeInfo>
}
