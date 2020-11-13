package com.pcsalt.example.githubtrending.trendinglist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pcsalt.example.githubtrending.R

class TrendingListFragment : Fragment(), TrendingListPresenterContract.View {

    private var presenter: TrendingListPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trending_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = TrendingListPresenter()
        presenter?.init()

        presenter?.search()
    }

    override fun onDestroyView() {
        presenter?.destroy()
        super.onDestroyView()
    }

    override fun onSearchResponse() {

    }


}