package com.kotlin.apiapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kotlin.apiapp.model.ProductItem

@Dao
interface DbDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProduct(productItem: List<ProductItem>)

    @Query("SELECT * from ProductItem")
    suspend fun getProducts():List<ProductItem>
}