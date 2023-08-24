package com.ahmet.bostanciklioglu.makeupappkotlin.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductColor(
    val hex_value: String, val colour_name: String
) : Parcelable