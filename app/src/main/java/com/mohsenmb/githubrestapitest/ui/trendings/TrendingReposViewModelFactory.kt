package com.mohsenmb.githubrestapitest.ui.trendings

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.mohsenmb.arch.data.ISchedulersProvider
import com.mohsenmb.arch.domain.RepositoryContract

class TrendingReposViewModelFactory constructor(
        private val repository: RepositoryContract.ITrendingReposRepository,
        private val schedulers: ISchedulersProvider) :
        ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TrendingReposViewModel(repository, schedulers) as T
    }
}