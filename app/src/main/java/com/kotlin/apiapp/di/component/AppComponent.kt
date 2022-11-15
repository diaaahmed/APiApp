package com.kotlin.apiapp.di.component

import android.content.Context
import com.kotlin.apiapp.MainActivity
import com.kotlin.apiapp.di.NetworkModule
import com.kotlin.apiapp.di.module.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Faker
    {
        fun create(@BindsInstance context: Context):AppComponent
    }
}