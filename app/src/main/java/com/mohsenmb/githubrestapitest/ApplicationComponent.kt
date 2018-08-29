package com.mohsenmb.githubrestapitest

import com.mohsenmb.arch.data.ApiServiceModule
import com.mohsenmb.githubrestapitest.data.ApiModule
import com.mohsenmb.githubrestapitest.ui.ApplicationModule
import com.mohsenmb.githubrestapitest.ui.ContributorsModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApiServiceModule::class,
    ApiModule::class,
    ApplicationModule::class,
    ContributorsModule::class
])
interface ApplicationComponent : AndroidInjector<GithubApplication> {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: GithubApplication): Builder

        fun build(): ApplicationComponent
    }

}