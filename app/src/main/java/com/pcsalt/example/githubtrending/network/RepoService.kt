package com.pcsalt.example.githubtrending.network

import android.util.Log
import com.pcsalt.example.githubtrending.model.*
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoService : IRepoService {
    private companion object {
        private const val TAG = "RepoService"
    }

    override fun searchRepo(query: String, order: String, sort: String) {
        NetworkService.getService().searchRepositories(query, order, sort)
            .enqueue(object : Callback<SearchRepo> {
                override fun onResponse(call: Call<SearchRepo>, response: Response<SearchRepo>) {
                    Log.d(TAG, "onResponse() called with: call = $call, response = $response")
                    Log.d(TAG, "success ${response.body()}")
                    EventBus.getDefault().post(UserRepoSuccessEvent(response.body()?.items))
                }

                override fun onFailure(call: Call<SearchRepo>, t: Throwable) {
                    Log.d(TAG, "onFailure() called with: call = $call, t = $t")
                    EventBus.getDefault()
                        .post(UserRepoFailureEvent(t.message ?: "Some error occurred"))
                }
            })
    }

    override fun getUserRepo(username: String) {
        NetworkService.getService().getUserRepos(username)
            .enqueue(object : Callback<List<RepoDetail>> {
                override fun onResponse(
                    call: Call<List<RepoDetail>>,
                    response: Response<List<RepoDetail>>
                ) {
                    Log.d(TAG, "onResponse() called with: call = $call, response = $response")
                    Log.d(TAG, "success ${response.body()}")
                    EventBus.getDefault().post(UserRepoSuccessEvent(response.body()))
                }

                override fun onFailure(call: Call<List<RepoDetail>>, t: Throwable) {
                    Log.d(TAG, "onFailure() called with: call = $call, t = $t")
                    EventBus.getDefault()
                        .post(UserRepoFailureEvent(t.message ?: "Some error occurred"))
                }
            })
    }

    override fun getRepoDetail(detailUrl: String) {
        NetworkService.getService().getRepoDetail(detailUrl)
            .enqueue(object : Callback<RepoDetail> {
                override fun onResponse(call: Call<RepoDetail>, response: Response<RepoDetail>) {
                    Log.d(TAG, "onResponse() called with: call = $call, response = $response")
                    Log.d(TAG, "success ${response.body()}")
                    EventBus.getDefault().post(RepoDetailSuccessEvent(response.body()))
                }

                override fun onFailure(call: Call<RepoDetail>, t: Throwable) {
                    Log.d(TAG, "onFailure() called with: call = $call, t = $t")
                    EventBus.getDefault()
                        .post(RepoDetailFailureEvent(t.message ?: "Some error occurred"))
                }
            })
    }
}