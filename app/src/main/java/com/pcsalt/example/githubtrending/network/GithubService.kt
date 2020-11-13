package com.pcsalt.example.githubtrending.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface GithubService {
    @GET("search/repositories")
    fun searchRepositories(
        @Query("q") q: String,
        @Query("order") order: String,
        @Query("sort") sort: String
    ): Call<Any>
}