package kz.vrstep.android_midterm

import android.app.Application
import kz.vrstep.android_midterm.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class FootballApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FootballApp)
            modules(
                appModule
            )
        }
    }
}