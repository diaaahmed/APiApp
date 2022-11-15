package com.kotlin.apiapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

typealias Category = String
typealias Description = String
typealias Title = String
typealias Image = String

@Entity
data class ProductItem(
    val category: Category,
    val description: Description,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val image: Image,
    val price: Double,
    val title: Title
)