package com.pcsalt.example.githubtrending.trendinglist

import com.pcsalt.example.githubtrending.base.BasePresenterContract
import com.pcsalt.example.githubtrending.model.RepoDetail

interface TrendingListPresenterContract : BasePresenterContract {
    interface View : BasePresenterContract.IView {
        fun getUsername(): String
        fun onSearchResponse(repoDetailList: List<RepoDetail>?)
    }

    interface Presenter : BasePresenterContract.IPresenter {
        fun search()
    }
}