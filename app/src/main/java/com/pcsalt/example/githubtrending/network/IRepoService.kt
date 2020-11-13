package com.pcsalt.example.githubtrending.network

interface IRepoService {

    fun searchRepo(query: String, order: String = "", sort: String = "")

    fun getRepoDetail()
}