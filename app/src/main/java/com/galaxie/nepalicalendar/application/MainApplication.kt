package com.galaxie.nepalicalendar.application

import android.app.Application
import timber.log.Timber
import com.galaxie.nepalicalendar.BuildConfig


class MainApplication : Application() {

    //change this tag for logging with filter in android studio...
    var TAG = "test"

    companion object {
        var instance: MainApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initTimberLogger()
    }




    private fun initTimberLogger() {
        if (BuildConfig.DEBUG) {
            // DebugTree has all usual logging functionality
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String? {
                    return String.format("[L:%s] [M:%s] [N:%s] [C:%s]",
                            element.lineNumber,
                            element.methodName,
                            element.className,
                            super.createStackElementTag(element))
                }

                override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                    //change this tag for logging with filter in android studio...
                    super.log(priority, TAG, message, t)
                }
            })
        }
    }


}