package com.kotlin.apiapp.db

import androidx.room.RoomDatabase
import com.kotlin.apiapp.model.ProductItem

@androidx.room.Database(entities = [ProductItem::class], version = 1)
abstract class Database: RoomDatabase() {

    abstract fun getDbDao():DbDao
}