package com.taghiashrafov.baseprojectdsl

import android.app.Application
import com.taghiashrafov.baseprojectdsl.di.ApplicationComponent

open class App : Application() {
    companion object {
        var appComponent: ApplicationComponent? = null
    }

    fun getComponent(): ApplicationComponent {
        if (appComponent == null) {
            appComponent = ApplicationComponent.init(this)
        }
        return appComponent!!
    }
}