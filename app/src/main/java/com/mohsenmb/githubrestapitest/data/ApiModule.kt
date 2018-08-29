package com.mohsenmb.githubrestapitest.data

import com.mohsenmb.arch.data.ISchedulersProvider
import com.mohsenmb.arch.data.NAMED_REST_API_URL
import com.mohsenmb.githubrestapitest.API_REST_URL
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    @Named(NAMED_REST_API_URL)
    fun provideRestApiUrl(): String = API_REST_URL

    @Provides
    fun provideSchedulersProvider(): ISchedulersProvider =
            SchedulersProvider()

}