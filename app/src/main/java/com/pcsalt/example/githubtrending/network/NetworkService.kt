package com.pcsalt.example.githubtrending.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {

    private var service: GithubService? = null

    private fun init() {
        val clientBuilder = OkHttpClient.Builder()

        val gson = GsonBuilder().create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(clientBuilder.build())
            .build()

        service = retrofit.create(GithubService::class.java)
    }

    fun getService(): GithubService {
        if (service == null) {
            init()
        }
        return service!!
    }
}