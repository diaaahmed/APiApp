package com.kotlin.apiapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kotlin.apiapp.R
import com.kotlin.apiapp.click.Click
import com.kotlin.apiapp.databinding.ProductItemBinding
import com.kotlin.apiapp.model.ProductItem


class ProductAdapter(var context: Context, var click:Click): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var productList = mutableListOf<ProductItem>()

    inner class ProductViewHolder(private var productItemBinding: ProductItemBinding):
        RecyclerView.ViewHolder(productItemBinding.root)
    {

        fun bind (product: List<ProductItem>, i: Int) = with(productItemBinding)
        {
            productName.text = product[i].title
            productPrice.text = product[i].price.toString()
            Glide.with(context).load(product[i].image)
                .placeholder(R.drawable.logo)
                .into(productImage)

            productItemBinding.root.setOnClickListener {
                click.click(product[i])
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder
    {
        return ProductViewHolder(
            ProductItemBinding.inflate
                (
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun getItemCount(): Int  = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int)
    {
        holder.bind(productList,position)
       // holder.bind(productList[position], position)

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setProducts(products: List<ProductItem>)
    {
        productList.addAll(products)
        notifyDataSetChanged()
    }
}