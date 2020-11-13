package com.pcsalt.example.githubtrending.model

data class UserRepoSuccessEvent(val data: List<RepoDetail>?)

data class UserRepoFailureEvent(val errorMessage: String)