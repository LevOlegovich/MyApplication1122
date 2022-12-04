package com.example.myapplication111122.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication111122.data.models.PhonesDto
import com.example.myapplication111122.databinding.FragmentPhonesBinding
import com.example.myapplication111122.presentation.adapters.bestseller.BestSellerAdapter
import com.example.myapplication111122.presentation.adapters.homestorehotsale.HotSaleAdapter
import com.example.myapplication111122.presentation.viewmodel.SharedPhonesViewModel
import com.example.myapplication111122.utils.ResourceState
import kotlinx.android.synthetic.main.fragment_phones.*


class PhonesFragment : Fragment() {

    private var _binding: FragmentPhonesBinding? = null
    private val binding: FragmentPhonesBinding
        get() = _binding ?: throw RuntimeException("FragmentPhonesBinding is null")

    lateinit var viewModel: SharedPhonesViewModel


    lateinit var hotSaleAdapter: HotSaleAdapter
    lateinit var bestSellerAdapter: BestSellerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentPhonesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()


        viewModel = ViewModelProvider(requireActivity()).get(SharedPhonesViewModel::class.java)

        viewModel.filterLiveData.observe(viewLifecycleOwner) {

            Log.d("PhonesFragmentFilterObserve: ", it.toString())
            viewModel.update()

        }
        viewModel.phonesLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is ResourceState.Success -> {
                    Log.d("PhonesFragmentObserve: ", it.data.toString())
                    showPhones(it)

                }
                is ResourceState.Error -> {
                    Log.d("PhonesFragmentObserve: ", it.message.toString())

                }
                is ResourceState.Loading -> {
                    Log.d("PhonesFragmentObserve: ", "loading...")

                }
            }
        }



    }


    private fun initAdapter() {
        hotSaleAdapter = HotSaleAdapter()
        binding.rcViewHotsale.apply {
            adapter = hotSaleAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        bestSellerAdapter = BestSellerAdapter()
        binding.rcViewBestSeller.apply {
            adapter = bestSellerAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }

    }


    private fun showPhones(resourceState: ResourceState<PhonesDto>) {
        if (viewModel.filterLiveData.value == null) {
            bestSellerAdapter.submitList(resourceState.data?.bestSeller)
            hotSaleAdapter.submitList(resourceState.data?.homeStoreHotSale)


        } else {
            var newBestSeller = resourceState.data?.let { phones -> viewModel.filterBrand(phones) }
            bestSellerAdapter.submitList(newBestSeller?.bestSeller)
            hotSaleAdapter.submitList(resourceState.data?.homeStoreHotSale)


        }

    }


}