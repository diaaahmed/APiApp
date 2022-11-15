package com.kotlin.apiapp

import android.app.Application
import com.kotlin.apiapp.di.component.AppComponent
import com.kotlin.apiapp.di.component.DaggerAppComponent

class MainApp: Application()
{

    lateinit var component:AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.factory().create(this)
    }
}