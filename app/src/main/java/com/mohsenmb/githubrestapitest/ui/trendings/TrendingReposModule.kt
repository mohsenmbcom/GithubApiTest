package com.mohsenmb.githubrestapitest.ui.trendings

import com.mohsenmb.arch.data.ISchedulersProvider
import com.mohsenmb.arch.domain.RepositoryContract
import dagger.Module
import dagger.Provides

@Module
class TrendingReposModule {

    @Provides
    fun provideTrendingReposViewModelFactory(repository: RepositoryContract.ITrendingReposRepository, schedulers: ISchedulersProvider) =
            TrendingReposViewModelFactory(repository, schedulers)
}