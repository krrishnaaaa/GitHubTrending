package com.pcsalt.example.githubtrending.network

import android.util.Log
import com.pcsalt.example.githubtrending.model.RepoDetail
import com.pcsalt.example.githubtrending.model.UserRepoFailureEvent
import com.pcsalt.example.githubtrending.model.UserRepoSuccessEvent
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoService : IRepoService {
    private companion object {
        private const val TAG = "RepoService"
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

    override fun getRepoDetail() {

    }
}