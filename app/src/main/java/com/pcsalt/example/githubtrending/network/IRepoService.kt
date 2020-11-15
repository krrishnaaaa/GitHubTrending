package com.pcsalt.example.githubtrending.network

interface IRepoService {

    fun searchRepo(query: String, order: String = "desc", sort: String = "updated")

    fun getRepoDetail(detailUrl: String)
}