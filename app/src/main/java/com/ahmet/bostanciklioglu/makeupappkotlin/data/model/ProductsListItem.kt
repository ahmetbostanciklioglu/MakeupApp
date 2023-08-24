package com.ahmet.bostanciklioglu.makeupappkotlin.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductsListItem(
    val id: Int? = null,
    val brand: String? = null,
    val name: String? = null,
    val price: String? = null,
    val price_sign: String? = null,
    val currency: String? = null,
    val image_link: String? = null,
    val product_link: String? = null,
    val website_link: String? = null,
    val description: String? = null,
    val rating: Double? = null,
    val category: String? = null,
    val product_type: String?,
    val tag_list: List<String?>? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val product_api_url: String? = null,
    val api_featured_image: String? = null,
    val product_colors: ArrayList<ProductColor?>? = null
) : Parcelable

