package com.ahmet.bostanciklioglu.makeupappkotlin.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmet.bostanciklioglu.makeupappkotlin.data.model.ProductsListItem
import com.ahmet.bostanciklioglu.makeupappkotlin.databinding.ProductRecyclerviewItemBinding


class ChildProductAdapter(
    private var productList: ArrayList<ProductsListItem>,
    private val listener: (ProductsListItem) -> Unit
) : RecyclerView.Adapter<ChildProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildProductViewHolder {
        return ChildProductViewHolder(
            ProductRecyclerviewItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            listener
        )
    }

    override fun getItemCount() = productList.count()

    override fun onBindViewHolder(holder: ChildProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }
}