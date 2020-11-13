package com.pcsalt.example.githubtrending.network

import android.util.Log
import com.pcsalt.example.githubtrending.model.SearchFailureEvent
import com.pcsalt.example.githubtrending.model.SearchSuccessEvent
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoService : IRepoService {
    private companion object {
        private const val TAG = "RepoService"
    }

    override fun searchRepo(query: String, order: String, sort: String) {
        val searchRepositories = NetworkService.getService().searchRepositories(query, order, sort)
        searchRepositories.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                Log.d(TAG, "onResponse() called with: call = $call, response = $response")
                Log.d(TAG, "success ${response.body()}")
                EventBus.getDefault().post(SearchSuccessEvent(response.body()))
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                Log.d(TAG, "onFailure() called with: call = $call, t = $t")
                EventBus.getDefault().post(SearchFailureEvent(t.message ?: "Some error occurred"))
            }
        })
    }

    override fun getRepoDetail() {

    }
}