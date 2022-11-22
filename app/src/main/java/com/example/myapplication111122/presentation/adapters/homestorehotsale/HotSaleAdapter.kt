package com.example.myapplication111122.presentation.adapters.homestorehotsale

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.myapplication111122.data.models.HomeStoreHotSale
import com.example.myapplication111122.databinding.ItemHotsaleBinding

class HotSaleAdapter : ListAdapter<HomeStoreHotSale, HotSaleViewHolder>(HotSaleDiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSaleViewHolder {
        val binding = ItemHotsaleBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HotSaleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotSaleViewHolder, position: Int) {
        val phoneHotSaleItem = getItem(position)
        holder.binding.apply {

            if (phoneHotSaleItem.isNew == true) {
                newLabel.visibility = View.VISIBLE
                newText.visibility = View.VISIBLE
            } else {
                newLabel.visibility = View.INVISIBLE
                newText.visibility = View.INVISIBLE

            }

            if (phoneHotSaleItem.isBuy == true) {
                buyBTN.visibility = View.VISIBLE
            } else {
                buyBTN.visibility = View.INVISIBLE
            }


            Glide.with(holder.itemView)
                .load(phoneHotSaleItem.picture)
             //   .centerCrop()
                .into(phohesImage)

            titleTv.text = phoneHotSaleItem.title
            subtitleTV.text = phoneHotSaleItem.subtitle



        }
    }


}


