package com.taghiashrafov.baseprojectdsl.di

import com.ashrafovtaghi.cache_api.DataStore
import com.ashrafovtaghi.cache_api.PrefUtils
import com.ashrafovtaghi.cache_impl.CacheApi
import dagger.Module
import dagger.Provides
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
}