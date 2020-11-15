package com.pcsalt.example.githubtrending.trendinglist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pcsalt.example.githubtrending.R
import com.pcsalt.example.githubtrending.detail.RepoDetailFragment
import com.pcsalt.example.githubtrending.model.RepoDetail
import com.pcsalt.example.githubtrending.util.DividerDecorator

class TrendingListFragment : Fragment(), TrendingListPresenterContract.View {

    private var presenter: TrendingListPresenter? = null
    private var recyclerView: RecyclerView? = null
    private var trendingAdapter: TrendingListAdapter? = null
    private var clickHandler = object : TrendingListAdapter.OnClickHandler {
        override fun onWebClick(webUrl: String) {
            Toast.makeText(activity, "web ur: $webUrl", Toast.LENGTH_SHORT).show()
        }

        override fun onDetailClick(detailUrl: String) {
            val bundle = Bundle()
            bundle.putString(RepoDetailFragment.EXTRA_DETAIL_URL, detailUrl)

            val repoDetailFragment = RepoDetailFragment()
            repoDetailFragment.arguments = bundle

            val simpleName = RepoDetailFragment::class.java.simpleName

            fragmentManager
                ?.beginTransaction()
                ?.add(R.id.container, repoDetailFragment, simpleName)
                ?.addToBackStack(simpleName)
                ?.commit()
        }
    }

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
        trendingAdapter?.clickHandler = null
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
            trendingAdapter?.clickHandler = clickHandler
        }
    }
}