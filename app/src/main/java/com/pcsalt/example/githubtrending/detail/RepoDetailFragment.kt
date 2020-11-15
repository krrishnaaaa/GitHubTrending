package com.pcsalt.example.githubtrending.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.pcsalt.example.githubtrending.R
import com.pcsalt.example.githubtrending.model.RepoDetail

class RepoDetailFragment : Fragment(), RepoPresenterContract.View {
    companion object {
        const val EXTRA_DETAIL_URL = "extra_detail_url"
    }

    private var presenter: RepoPresenter? = null
    private var tvRepoName: TextView? = null
    private var tvRepoDescription: TextView? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_repo_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = RepoPresenter()
        presenter?.init(this)

        tvRepoName = view.findViewById(R.id.tv_repo_name)
        tvRepoDescription = view.findViewById(R.id.tv_repo_description)

        presenter?.getDetail()
    }

    override fun onDestroyView() {
        presenter?.destroy()
        super.onDestroyView()
    }

    override fun getDetailUrl(): String? {
        return arguments?.getString(EXTRA_DETAIL_URL)
    }

    override fun onDetailResponse(repoDetail: RepoDetail?) {
        repoDetail?.let {
            tvRepoName?.text = it.fullName
            tvRepoDescription?.text = it.description
        }
    }
}