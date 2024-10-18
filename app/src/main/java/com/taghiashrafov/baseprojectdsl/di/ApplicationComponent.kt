package com.taghiashrafov.baseprojectdsl.di

import com.taghiashrafov.baseprojectdsl.App
import com.taghiashrafov.baseprojectdsl.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
//        AppDependenciesModule::class,
//        AppApiModule::class
    ]
)
@Singleton
interface ApplicationComponent {

    companion object {
        fun init(app: App): ApplicationComponent {
            return DaggerApplicationComponent
                .builder()
                .appModule(AppModule(app))
                .build()
        }
    }

    fun inject(app: App)
    fun inject(activity: MainActivity)
}