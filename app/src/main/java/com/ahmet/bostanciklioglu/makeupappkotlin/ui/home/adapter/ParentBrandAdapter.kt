package com.ahmet.bostanciklioglu.makeupappkotlin.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahmet.bostanciklioglu.makeupappkotlin.data.model.GroupedProductsList
import com.ahmet.bostanciklioglu.makeupappkotlin.data.model.ProductsListItem
import com.ahmet.bostanciklioglu.makeupappkotlin.databinding.ProductRecyclerviewBinding

class ParentBrandAdapter(
    private val listener: (ProductsListItem) -> Unit
) : RecyclerView.Adapter<ParentBrandViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<GroupedProductsList>() {
        override fun areItemsTheSame(
            oldItem: GroupedProductsList, newItem: GroupedProductsList
        ): Boolean {
            return oldItem.brand == newItem.brand
        }

        override fun areContentsTheSame(
            oldItem: GroupedProductsList, newItem: GroupedProductsList
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentBrandViewHolder {
        return ParentBrandViewHolder(
            ProductRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), listener
        )
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: ParentBrandViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }
}
