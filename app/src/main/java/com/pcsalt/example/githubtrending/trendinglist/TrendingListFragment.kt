package com.pcsalt.example.githubtrending.trendinglist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pcsalt.example.githubtrending.R
import com.pcsalt.example.githubtrending.model.RepoDetail
import com.pcsalt.example.githubtrending.util.DividerDecorator

class TrendingListFragment : Fragment(), TrendingListPresenterContract.View {

    private var presenter: TrendingListPresenter? = null
    private var recyclerView: RecyclerView? = null
    private var trendingAdapter: TrendingListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trending_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = TrendingListPresenter()
        presenter?.init(this)

        recyclerView = view.findViewById(R.id.rv_repo_list)
        initRecycler()

        presenter?.search()
    }

    override fun onDestroyView() {
        presenter?.destroy()
        trendingAdapter = null
        recyclerView?.adapter = null
        super.onDestroyView()
    }

    override fun getUsername(): String {
        return "krrishnaaaa"
    }

    override fun onSearchResponse(repoDetailList: List<RepoDetail>?) {
        repoDetailList?.let {
            trendingAdapter?.repoList = it
            trendingAdapter?.notifyDataSetChanged()
        }
    }

    private fun initRecycler() {
        trendingAdapter = TrendingListAdapter()
        recyclerView?.apply {
            adapter = trendingAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerDecorator())
        }
    }


}