package com.kotlin.apiapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.apiapp.model.ProductItem
import com.kotlin.apiapp.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel()
{
    val products: LiveData<List<ProductItem>> get() = repository.products

    init{
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}