package com.pcsalt.example.githubtrending.trendinglist

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pcsalt.example.githubtrending.R
import com.pcsalt.example.githubtrending.model.RepoDetail

class TrendingListAdapter : RecyclerView.Adapter<TrendingListAdapter.VH>() {

    var repoList: List<RepoDetail> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_repo, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.displayData(repoList[position])
    }

    override fun getItemCount(): Int = repoList.size

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvRepoName: TextView = itemView.findViewById(R.id.tv_repo_name)
        private val tvUsername: TextView = itemView.findViewById(R.id.tv_username)
        private val tvDescription: TextView = itemView.findViewById(R.id.tv_repo_description)

        fun displayData(data: RepoDetail) {
            tvRepoName.text = data.name
            if (data.fork) {
                tvRepoName.append(" (Forked)")
            }

            if (!TextUtils.isEmpty(data.language)) {
                tvRepoName.append(" -- ${data.language}")
            }

            tvUsername.text = data.owner.login
            tvDescription.text = data.description
        }
    }
}