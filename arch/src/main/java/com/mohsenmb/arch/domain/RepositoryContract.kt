package com.mohsenmb.arch.domain

import io.reactivex.Single

interface RepositoryContract {
    interface ITrendingReposRepository {
        fun loadTrendingRepos(page: Int): Single<ReposContainer>
    }
}