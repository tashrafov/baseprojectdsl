package com.taghiashrafov.baseprojectdsl.di

import com.ashrafovtaghi.cache_api.DataStore
import com.ashrafovtaghi.cache_api.PrefUtils
import com.ashrafovtaghi.cache_impl.CacheApi
import com.ashrafovtaghi.retrofit.NetworkApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AppApiModule{
    @Singleton
    @Provides
    fun providePrefUtilsApi(cacheApi: CacheApi): PrefUtils {
        return cacheApi.getPrefUtils()
    }

    @Singleton
    @Provides
    fun provideDataStoreApi(cacheApi: CacheApi): DataStore {
        return cacheApi.getDataStore()
    }

    @Provides
    @Singleton
    fun provideRetrofit(networkApi: NetworkApi): Retrofit {
        return networkApi.getRetrofit()
    }
}