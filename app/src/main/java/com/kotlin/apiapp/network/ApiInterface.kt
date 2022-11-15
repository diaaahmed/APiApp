package com.kotlin.apiapp.network

import com.kotlin.apiapp.model.ProductItem
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")
    suspend fun getProducts(): List<ProductItem>
}

