package com.pcsalt.example.githubtrending.model

import com.google.gson.annotations.SerializedName

data class RepoDetail(
    val id: Long,
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    val fork: Boolean,
    @SerializedName("html_url")
    val htmlUrl: String,
    val url: String,
    val owner: Owner,
    val description: String,
    val language: String
) {
    constructor() : this(0, "", "", false, "", "", Owner(), "", "")
}