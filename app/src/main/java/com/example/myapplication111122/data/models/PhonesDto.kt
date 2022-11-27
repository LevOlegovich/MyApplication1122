package com.example.myapplication111122.data.models

import com.google.gson.annotations.SerializedName

data class PhonesDto(
    @SerializedName("home_store") val homeStoreHotSale: List<HomeStoreHotSale>?,
    @SerializedName("best_seller") val bestSeller: List<BestSellerDto>?
)