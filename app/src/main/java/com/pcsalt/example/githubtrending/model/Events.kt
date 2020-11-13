package com.pcsalt.example.githubtrending.model

data class SearchSuccessEvent(val data: Any?)

data class SearchFailureEvent(val errorMessage: String)