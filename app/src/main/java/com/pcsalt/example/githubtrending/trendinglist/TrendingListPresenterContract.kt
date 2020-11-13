package com.pcsalt.example.githubtrending.trendinglist

import com.pcsalt.example.githubtrending.base.BasePresenterContract

interface TrendingListPresenterContract : BasePresenterContract {
    interface View : BasePresenterContract.IView {
        fun onSearchResponse()
    }

    interface Presenter : BasePresenterContract.IPresenter {
        fun search()
    }
}