package com.pcsalt.example.githubtrending.trendinglist

import android.util.Log
import com.pcsalt.example.githubtrending.base.BasePresenterContract
import com.pcsalt.example.githubtrending.model.UserRepoFailureEvent
import com.pcsalt.example.githubtrending.model.UserRepoSuccessEvent
import com.pcsalt.example.githubtrending.network.RepoService
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class TrendingListPresenter : TrendingListPresenterContract.Presenter {
    private var view: TrendingListPresenterContract.View? = null

    override fun init(view: BasePresenterContract.IView?) {
        this.view = view as TrendingListPresenterContract.View?
        EventBus.getDefault().register(this)
    }

    override fun destroy() {
        this.view = null
        EventBus.getDefault().unregister(this)
    }

    override fun isAttached(): Boolean = view != null

    override fun search() {
        if (isAttached()) {
            view?.let {
                val repoService = RepoService()
                repoService.getUserRepo(it.getUsername())
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onSearchSuccess(data: UserRepoSuccessEvent) {
        Log.d("presenter", "data: $data")
        if (isAttached()) view?.onSearchResponse(data.repoDetailList)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onSearchFailure(data: UserRepoFailureEvent) {
        Log.d("presenter", "error message: $data")
    }
}