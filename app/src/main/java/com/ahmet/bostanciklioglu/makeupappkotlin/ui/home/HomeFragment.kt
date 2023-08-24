package com.ahmet.bostanciklioglu.makeupappkotlin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ahmet.bostanciklioglu.makeupappkotlin.R
import com.ahmet.bostanciklioglu.makeupappkotlin.databinding.FragmentHomeBinding
import com.ahmet.bostanciklioglu.makeupappkotlin.ui.home.adapter.ParentBrandAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MakeupViewModel by viewModels()
    private val adapter by lazy {
        ParentBrandAdapter {
            val action = HomeFragmentDirections.actionHomeFragmentToMakeupProductFragment(it)
            findNavController().navigate(action)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        setupRecyclerview()
        observeData()

        return view
    }

    private fun setupRecyclerview() {
        binding.rvParent.adapter = adapter
    }

    private fun observeData() {
        with(viewModel) {
            groupedProductsList.observe(viewLifecycleOwner) { list ->
                adapter.differ.submitList(list)
            }

            loading.observe(viewLifecycleOwner) { loading ->
                if (loading) showProgressBar() else hideProgressBar()
            }

            errorMessage.observe(viewLifecycleOwner) { errorMessage ->
                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.INVISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}