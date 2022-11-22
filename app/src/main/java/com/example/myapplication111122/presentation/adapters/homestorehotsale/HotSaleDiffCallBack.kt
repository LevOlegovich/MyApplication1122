package com.example.myapplication111122.presentation.adapters.homestorehotsale

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication111122.data.models.HomeStoreHotSale

object HotSaleDiffCallBack : DiffUtil.ItemCallback<HomeStoreHotSale>() {
    override fun areItemsTheSame(oldItem: HomeStoreHotSale, newItem: HomeStoreHotSale): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HomeStoreHotSale, newItem: HomeStoreHotSale): Boolean {
        return oldItem == newItem
    }

}
