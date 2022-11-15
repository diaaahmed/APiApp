package com.kotlin.apiapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kotlin.apiapp.db.Database
import com.kotlin.apiapp.db.DbDao
import com.kotlin.apiapp.model.ProductItem
import com.kotlin.apiapp.network.ApiInterface
import javax.inject.Inject

class Repository @Inject constructor(private val api:ApiInterface, private val dao:Database)
{
    private val _products = MutableLiveData<List<ProductItem>>()
    val products: LiveData<List<ProductItem>> get() = _products

    suspend fun getProducts()
    {
        val result = api.getProducts()
        dao.getDbDao().addProduct(result)
        _products.postValue(result)
    }
}