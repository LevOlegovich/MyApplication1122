package com.example.myapplication111122.presentation.adapters.bestseller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.myapplication111122.R
import com.example.myapplication111122.data.models.BestSellerDto
import com.example.myapplication111122.databinding.ItemBestsellerBinding
import java.text.DecimalFormat

class BestSellerAdapter : ListAdapter<BestSellerDto, BestSellerViewHolder>(BestSellerDiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val binding = ItemBestsellerBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return BestSellerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        val phoneBestSellerItem = getItem(position)
        holder.binding.apply {


            Glide.with(holder.itemView)
                .load(phoneBestSellerItem.picture)
                //   .centerCrop()
                .into(phohesImage)

            if (phoneBestSellerItem.isFavorites == true) {
                favoriteImage.setImageResource(R.drawable.ic_favorite)
            } else {
                favoriteImage.setImageResource(R.drawable.ic_unfavorite)
            }
            val decim = DecimalFormat("#,###.##")

            var priceDiscount = "$ %s"
            priceWithDiscount.text =
//                String.format(priceDiscount, phoneBestSellerItem.priceWithoutDiscount)
                String.format(priceDiscount, decim.format(phoneBestSellerItem.discountPrice))
            priceDiscountLineTextCrossOut.text = phoneBestSellerItem.discountPrice.toString()
            titleTV.text = phoneBestSellerItem.title


        }
    }


}


