package com.pcsalt.example.githubtrending.detail

import com.pcsalt.example.githubtrending.base.BasePresenterContract
import com.pcsalt.example.githubtrending.model.RepoDetail

interface RepoPresenterContract : BasePresenterContract {
    interface View : BasePresenterContract.IView {
        fun getDetailUrl(): String?
        fun onDetailResponse(repoDetail: RepoDetail?)
    }

    interface Presenter : BasePresenterContract.IPresenter {
        fun getDetail()
    }
}