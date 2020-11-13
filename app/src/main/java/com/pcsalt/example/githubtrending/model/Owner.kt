package com.pcsalt.example.githubtrending.model

data class Owner(val login: String, val id: Long) {
    constructor() : this("", 0)
}