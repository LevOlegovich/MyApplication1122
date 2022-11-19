package com.example.myapplication111122.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication111122.data.CategoriesModel
import com.example.myapplication111122.presentation.fragments.EmptyFragment
import com.example.myapplication111122.presentation.fragments.PhonesFragment

class TablayoutAdapter(private val categoryList: List<CategoriesModel>, fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (categoryList[position].id) {
            0 -> PhonesFragment()
            else -> EmptyFragment()
        }
    }
}