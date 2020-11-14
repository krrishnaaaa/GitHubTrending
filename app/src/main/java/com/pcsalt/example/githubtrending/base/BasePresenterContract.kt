package com.pcsalt.example.githubtrending.base

interface BasePresenterContract {
    interface IView {

    }

    interface IPresenter {
        fun init(view: IView?)
        fun destroy()
        fun isAttached(): Boolean
    }
}