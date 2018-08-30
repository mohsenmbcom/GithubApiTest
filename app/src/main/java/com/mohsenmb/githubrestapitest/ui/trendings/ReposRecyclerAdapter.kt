package com.mohsenmb.githubrestapitest.ui.trendings

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mohsenmb.arch.domain.Repo
import com.mohsenmb.githubrestapitest.BR
import com.mohsenmb.githubrestapitest.R

class ReposRecyclerAdapter(val repos: MutableList<Repo>)
    : RecyclerView.Adapter<DataBindingViewHolder>() {
    var onRepoItemClickListener: ((Repo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            DataBindingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.row_repo, parent, false)
        return DataBindingViewHolder(binding)
    }

    override fun getItemCount(): Int = repos.size

    override fun onBindViewHolder(holder: DataBindingViewHolder, position: Int) {
        holder.bindVariable(BR.repo, repos[position])
        holder.itemView.setOnClickListener { _ ->
            onRepoItemClickListener?.let { it(repos[holder.adapterPosition]) }
        }
    }

}