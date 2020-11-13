package com.pcsalt.example.githubtrending.network

interface IRepoService {

    fun getUserRepo(username: String)

    fun getRepoDetail()
}