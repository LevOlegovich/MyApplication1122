package com.example.myapplication111122.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication111122.databinding.FragmentEmptyBinding


class EmptyFragment : Fragment() {


    private var _binding: FragmentEmptyBinding? = null
    private val binding: FragmentEmptyBinding
        get() = _binding ?: throw RuntimeException("FragmentEmptyBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmptyBinding.inflate(inflater, container, false)
        return binding.root
    }


}