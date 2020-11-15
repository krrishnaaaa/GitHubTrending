package com.pcsalt.example.githubtrending.network

import com.pcsalt.example.githubtrending.model.RepoDetail
import com.pcsalt.example.githubtrending.model.SearchRepo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url


interface GithubService {
    @GET("search/repositories")
    fun searchRepositories(
        @Query("q") q: String,
        @Query("order") order: String,
        @Query("sort") sort: String
    ): Call<SearchRepo>

    @GET("users/{username}/repos")
    fun getUserRepos(@Path("username") username: String): Call<List<RepoDetail>>

    @GET
    fun getRepoDetail(@Url detailUrl: String): Call<RepoDetail>
}