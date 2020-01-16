package kr.ac.jejunu.hwahae.application

import android.app.Application
import kr.ac.jejunu.hwahae.model.di.retrofit
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(retrofit))
    }
}