package com.pcsalt.example.githubtrending.model

data class UserRepoSuccessEvent(val repoDetailList: List<RepoDetail>?)

data class UserRepoFailureEvent(val errorMessage: String)

data class RepoDetailSuccessEvent(val repoDetail: RepoDetail?)

data class RepoDetailFailureEvent(val errorMessage: String)