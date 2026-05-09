package org.rdk.todo

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.rdk.todo.di.initializeKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin(
            config = { androidContext(this@MyApplication) }
        )
    }
}