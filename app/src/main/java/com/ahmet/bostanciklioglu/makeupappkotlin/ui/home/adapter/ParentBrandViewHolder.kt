package com.ahmet.bostanciklioglu.makeupappkotlin.ui.home.adapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahmet.bostanciklioglu.makeupappkotlin.data.model.GroupedProductsList
import com.ahmet.bostanciklioglu.makeupappkotlin.data.model.ProductsListItem
import com.ahmet.bostanciklioglu.makeupappkotlin.databinding.ProductRecyclerviewBinding


class ParentBrandViewHolder(
    private val binding: ProductRecyclerviewBinding,
    private val listener: (ProductsListItem) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(productItem: GroupedProductsList) {
        val childAdapter =
            ChildProductAdapter(productItem.productsLists as ArrayList<ProductsListItem>) {
                listener.invoke(it)
            }

        binding.apply {
            tvBrandname.text = productItem.brand
            rvChild.layoutManager = LinearLayoutManager(
                itemView.context, LinearLayoutManager.HORIZONTAL, false
            )
            rvChild.adapter = childAdapter
        }
    }
}


