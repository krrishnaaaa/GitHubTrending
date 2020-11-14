package com.pcsalt.example.githubtrending.model

import com.google.gson.annotations.SerializedName

data class SearchRepo(
    @SerializedName("total_count")
    val totalCount: Int,
    val items: List<RepoDetail>
) {
    constructor() : this(0, emptyList<RepoDetail>())
}