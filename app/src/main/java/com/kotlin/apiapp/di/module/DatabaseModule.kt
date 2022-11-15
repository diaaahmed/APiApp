package com.kotlin.apiapp.di.module

import android.content.Context
import androidx.room.Room
import com.kotlin.apiapp.db.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context):Database{
        return Room.databaseBuilder(context,Database::class.java,"Database").build()
    }

}