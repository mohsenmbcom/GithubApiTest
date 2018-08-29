package com.mohsenmb.githubrestapitest.ui.trendings

import android.os.Bundle
import android.view.View
import com.mohsenmb.githubrestapitest.R
import com.mohsenmb.githubrestapitest.ui.BaseFragment

class TrendingReposFragment : BaseFragment() {

    companion object {
        fun newInstance(): TrendingReposFragment = TrendingReposFragment()
    }

    override fun onViewReady(view: View, savedInstanceState: Bundle?) {

    }

    override fun getLayoutId(): Int = R.layout.fragment_trending_repos
}