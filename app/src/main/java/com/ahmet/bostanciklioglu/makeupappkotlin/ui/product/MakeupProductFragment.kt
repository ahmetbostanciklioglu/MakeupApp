package com.ahmet.bostanciklioglu.makeupappkotlin.ui.product

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.ahmet.bostanciklioglu.makeupappkotlin.R
import com.ahmet.bostanciklioglu.makeupappkotlin.databinding.FragmentMakeupProductBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MakeupProductFragment : DialogFragment() {

    private var _binding: FragmentMakeupProductBinding? = null
    private val binding get() = _binding!!
    private val arg: MakeupProductFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.AppThemeFullScreenDialog)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMakeupProductBinding.inflate(inflater, container, false)
        val view = binding.root

       val product = arg.productData

       // Print message if data is transferred
        product.brand.let { Timber.tag("MakeupProduct").d("Success") }

        // Attach product data to views
        binding.apply {
           Picasso.get().load(product.image_link).into(ivProductImage)
            tvBrandName.text = product.brand
            tvProductName.text = product.name
            tvPrice.text = "$" + product.price
            tvDescription.text = product.description
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}