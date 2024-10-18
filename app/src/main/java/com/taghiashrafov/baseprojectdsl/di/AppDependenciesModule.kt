package com.taghiashrafov.baseprojectdsl.di

import android.content.Context
import com.ashrafovtaghi.cache_impl.CacheApi
import com.ashrafovtaghi.cache_impl.di.CoreCacheComponentHolder
import com.ashrafovtaghi.cache_impl.di.CoreCacheDependencies
import com.ashrafovtaghi.retrofit.NetworkApi
import com.ashrafovtaghi.retrofit.di.NetworkComponentHolder
import com.ashrafovtaghi.retrofit.di.NetworkDependencies
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
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

    @Singleton
    @Provides
    fun provideRetrofitDependencies(context: Context): NetworkDependencies =
        object : NetworkDependencies {
            override val context: Context = context
            override val baseUrl: String = "https://ghibliapi.herokuapp.com"// for test
            override val networkInterceptors: List<Interceptor> = emptyList()
        }

    @Singleton
    @Provides
    fun provideRetrofitApi(retrofitDeps: NetworkDependencies): NetworkApi {
        NetworkComponentHolder.init(retrofitDeps)
        return NetworkComponentHolder.get()
    }

}