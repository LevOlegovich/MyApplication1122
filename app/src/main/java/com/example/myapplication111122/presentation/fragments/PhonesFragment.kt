package com.example.myapplication111122.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import com.example.myapplication111122.databinding.FragmentPhonesBinding
import com.example.myapplication111122.presentation.viewmodel.PhonesViewModel
import com.example.myapplication111122.utils.ResourceState


class PhonesFragment : Fragment() {

    private var _binding: FragmentPhonesBinding? = null
    private val binding: FragmentPhonesBinding
        get() = _binding ?: throw RuntimeException("FragmentPhonesBinding is null")

    private val viewModel by viewModels<PhonesViewModel>()

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
        viewModel.loadPhones()
        viewModel.phonesLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is ResourceState.Success -> {
                    Log.d("PhonesFragment: ", it.data.toString())

                }
                is ResourceState.Error -> {
                    Log.d("PhonesFragment: ", it.message.toString())

                }
                is ResourceState.Loading -> {
                    Log.d("PhonesFragment: ", "loading...")

                }
            }
        }

    }


}