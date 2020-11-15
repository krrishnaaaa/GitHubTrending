package com.pcsalt.example.githubtrending.detail

import android.util.Log
import com.pcsalt.example.githubtrending.base.BasePresenterContract
import com.pcsalt.example.githubtrending.model.RepoDetailFailureEvent
import com.pcsalt.example.githubtrending.model.RepoDetailSuccessEvent
import com.pcsalt.example.githubtrending.network.RepoService
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class RepoPresenter : RepoPresenterContract.Presenter {
    private var view: RepoPresenterContract.View? = null

    override fun init(view: BasePresenterContract.IView?) {
        this.view = view as RepoPresenterContract.View?
        EventBus.getDefault().register(this)
    }

    override fun destroy() {
        this.view = null
        EventBus.getDefault().unregister(this)
    }

    override fun isAttached(): Boolean = view != null

    override fun getDetail() {
        if (isAttached()) {
            view?.let {
                val detailUrl = it.getDetailUrl()
                if (detailUrl != null) {
                    val repoService = RepoService()
                    repoService.getRepoDetail(detailUrl)
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onSearchSuccess(data: RepoDetailSuccessEvent) {
        Log.d("detail presenter", "data: $data")
        if (isAttached()) view?.onDetailResponse(data.repoDetail)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onSearchFailure(data: RepoDetailFailureEvent) {
        Log.d("detail presenter", "error message: $data")
    }
}