package com.pcsalt.example.githubtrending.trendinglist

import android.util.Log
import com.pcsalt.example.githubtrending.model.SearchFailureEvent
import com.pcsalt.example.githubtrending.model.SearchSuccessEvent
import com.pcsalt.example.githubtrending.network.RepoService
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class TrendingListPresenter : TrendingListPresenterContract.Presenter {

    override fun init() {
        EventBus.getDefault().register(this)
    }

    override fun destroy() {
        EventBus.getDefault().unregister(this)
    }

    override fun search() {
        val repoService = RepoService()
        repoService.searchRepo("", "", "")
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onSearchSuccess(data: SearchSuccessEvent) {
        Log.d("presenter", "data: $data")
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onSearchFailure(data: SearchFailureEvent) {
        Log.d("presenter", "error message: $data")
    }
}