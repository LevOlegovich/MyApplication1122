package com.example.myapplication111122.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication111122.R
import com.example.myapplication111122.data.models.FilterModel
import com.example.myapplication111122.databinding.FiltersDialogBinding
import com.example.myapplication111122.presentation.viewmodel.SharedPhonesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.filters_dialog.*

class FilterBottomSheetDialog() : BottomSheetDialogFragment() {

    private var _binding: FiltersDialogBinding? = null
    private val binding: FiltersDialogBinding
        get() = _binding ?: throw RuntimeException("FragmentEmptyBinding is null")
    lateinit var viewModel: SharedPhonesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.TransparentBackgroundBottomSheet)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FiltersDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SharedPhonesViewModel::class.java)

        getAndSetupFilter()
        binding.doneBtn.setOnClickListener {
            viewModel.saveFilter(

                FilterModel(
                    brandSpinner.selectedItem.toString(),
                    priceSpinner.selectedItem.toString(),
                    sizeSpinner.selectedItem.toString()
                )
            )
            dismiss()
        }

        binding.closeBtn.setOnClickListener {
            dismiss()
        }
    }

    private fun getAndSetupFilter() {
        val listBrand = resources.getStringArray(R.array.brand_spinner)
        brandSpinner.setSelection(listBrand.indexOf(viewModel.filterLiveData.value?.brand))

        val listPrice = resources.getStringArray(R.array.price_spinner)
        priceSpinner.setSelection(listPrice.indexOf(viewModel.filterLiveData.value?.price))

        val listSize = resources.getStringArray(R.array.size_spinner)
        sizeSpinner.setSelection(listSize.indexOf(viewModel.filterLiveData.value?.size))
    }


}


