package com.mohsenmb.githubrestapitest.ui.trendings

import com.mohsenmb.arch.data.TrendingReposRepository
import com.mohsenmb.arch.domain.RepositoryContract
import dagger.Module

@Module
class TrendingReposModule {

    fun provideTrendingReposRepository(trendingReposRepository: TrendingReposRepository): RepositoryContract.ITrendingReposRepository =
            trendingReposRepository
}