package com.taghiashrafov.baseprojectdsl.di

import android.content.Context
import com.ashrafovtaghi.cache_impl.CacheApi
import com.ashrafovtaghi.cache_impl.di.CoreCacheComponentHolder
import com.ashrafovtaghi.cache_impl.di.CoreCacheDependencies
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppDependenciesModule {
    @Singleton
    @Provides
    fun provideCoreCacheDependencies(context: Context): CoreCacheDependencies =
        object : CoreCacheDependencies {
            override val context: Context = context
            override val storageName: String = "base_project"
        }

    @Singleton
    @Provides
    fun provideCacheApi(cacheDeps: CoreCacheDependencies): CacheApi {
        CoreCacheComponentHolder.init(cacheDeps)
        return CoreCacheComponentHolder.get()
    }
}