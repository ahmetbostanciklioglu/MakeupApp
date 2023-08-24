package com.ahmet.bostanciklioglu.makeupappkotlin.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.ahmet.bostanciklioglu.makeupappkotlin.data.model.ProductsListItem
import com.ahmet.bostanciklioglu.makeupappkotlin.databinding.ProductRecyclerviewItemBinding
import com.squareup.picasso.Picasso
import timber.log.Timber

class ChildProductViewHolder(
    private val binding: ProductRecyclerviewItemBinding,
    private val listener: (ProductsListItem) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(productItem: ProductsListItem) {
        binding.apply {
            tvBrandName.text = productItem.brand
            tvProductName.text = productItem.name
            productItem.image_link?.let { imageLink ->
                Picasso.get().load(imageLink).into(ivProductImage)
            }

            //Once the item view is clicked the item product data is passed to the
            root.setOnClickListener {
                Timber.tag("ChildProductAdapter").d("Checking..")
                listener.invoke(productItem)
            }
        }
    }
}


