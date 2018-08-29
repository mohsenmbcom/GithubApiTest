package com.mohsenmb.githubrestapitest.ui

import com.mohsenmb.arch.data.TrendingReposRepositoryModule
import com.mohsenmb.githubrestapitest.ui.trendings.TrendingReposFragment
import com.mohsenmb.githubrestapitest.ui.trendings.TrendingReposModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ContributorsModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [TrendingReposRepositoryModule::class, TrendingReposModule::class])
    abstract fun bindTrendingReposFragment(): TrendingReposFragment
}