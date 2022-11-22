package com.example.myapplication111122.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BestSellerDto(

    @SerializedName("discount_price") val discountPrice: Int?,
    val id: Int?,
    @SerializedName("is_favorites") val isFavorites: Boolean?,
    val picture: String?,
    @SerializedName("price_without_discount") val priceWithoutDiscount: Int?,
    val title: String?
)