package com.example.myapplication111122.presentation.adapters.bestseller

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication111122.data.models.BestSellerDto

object BestSellerDiffCallBack : DiffUtil.ItemCallback<BestSellerDto>() {
    override fun areItemsTheSame(oldItem: BestSellerDto, newItem: BestSellerDto): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BestSellerDto, newItem: BestSellerDto): Boolean {
        return oldItem == newItem
    }

}
