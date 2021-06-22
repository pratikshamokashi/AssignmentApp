package com.equinoxlabs.demoassignmentapp.Presentation.view

import android.app.Application
import com.equinoxlabs.demoassignmentapp.Presentation.di.PostModule
import com.equinoxlabs.demoassignmentapp.Presentation.di.networkModule
import com.facebook.stetho.Stetho
import com.go2future.tuvoclient.data.local.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class UserApplication : Application(){

    companion object {
        private lateinit var instance: UserApplication
        fun getInstance(): UserApplication = instance
        var database: AppDatabase? = null


    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        instance = this
        startKoin {
            androidLogger()
            androidContext(this@UserApplication)
            modules(
                listOf(
                    PostModule,
                    networkModule
                )
            )
        }
//        database = Room.databaseBuilder(applicationContext, LanguageRoomDB::class.java, "language")
//            .fallbackToDestructiveMigration().build()
//        getTokenForFirebase()

    }
}