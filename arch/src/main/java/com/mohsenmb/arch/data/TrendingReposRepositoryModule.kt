package com.mohsenmb.arch.data

import com.mohsenmb.arch.domain.RepositoryContract
import dagger.Module
import dagger.Provides

@Module
class TrendingReposRepositoryModule {
    @Provides
    fun provideTrendingReposRepository(repository: TrendingReposRepository):
            RepositoryContract.ITrendingReposRepository = repository
}