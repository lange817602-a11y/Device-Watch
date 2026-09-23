package org.jarsi.devicewatch

import android.app.Application
import com.bugfender.sdk.Bugfender
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MonitorApp : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.BUGFENDER_APP_KEY.isNotBlank()) {
            Bugfender.init(this, BuildConfig.BUGFENDER_APP_KEY, BuildConfig.DEBUG)
        }
    }
}
