package com.mohsenmb.arch.data

import com.mohsenmb.arch.domain.ReposContainer
import com.mohsenmb.arch.domain.RepositoryContract
import io.reactivex.Single
import javax.inject.Inject

class TrendingReposRepository @Inject constructor(private val webservice: GithubWebservice,
                                                      private val schedulersProvider: SchedulersProvider)
    : RepositoryContract.ITrendingReposRepository {
    override fun loadTrendingRepos(page: Int): Single<ReposContainer> =
            webservice
                    .loadTrendingRepos(page)
                    .subscribeOn(schedulersProvider.io())
}