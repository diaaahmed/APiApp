package com.kotlin.apiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kotlin.apiapp.adapter.ProductAdapter
import com.kotlin.apiapp.click.Click
import com.kotlin.apiapp.common.Common
import com.kotlin.apiapp.databinding.ActivityMainBinding
import com.kotlin.apiapp.model.ProductItem
import com.kotlin.apiapp.viewModel.MainViewModel
import com.kotlin.apiapp.viewModel.MainViewModelFactory
import javax.inject.Inject

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(),Click
{
    lateinit var mainViewModel: MainViewModel

    private val adapter by lazy  {
        ProductAdapter(this,this)
    }

    private val ui by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var mainViewModelFactoryDI: MainViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui.root)

        ui.productsRecyclerview.setHasFixedSize(true)

        (application as MainApp).component.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModelFactoryDI)[MainViewModel::class.java]

        mainViewModel.products.observe(this, Observer {
            data->
            Log.d(TAG, "result: ${data[0].description}")
            adapter.setProducts(data)
            ui.productsRecyclerview.adapter = adapter
        })

    }

    override fun click(product: ProductItem)
    {
        Common.showMessage(this,"Product title it ${product.title}")
    }
}