package com.pcsalt.example.githubtrending.model

data class UserRepoSuccessEvent(val repoDetailList: List<RepoDetail>?)

data class UserRepoFailureEvent(val errorMessage: String)