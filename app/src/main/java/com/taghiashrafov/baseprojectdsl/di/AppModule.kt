package com.taghiashrafov.baseprojectdsl.di

import com.taghiashrafov.baseprojectdsl.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {
    @Provides
    @Singleton
    fun provideApplicationContext() = app.applicationContext
}