package com.example.myapplication111122.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PhonesDto(
    @SerializedName("home_store") val homeStoreHotSale: List<HomeStoreHotSale>?,
    @SerializedName("best_seller") val bestSeller: List<BestSellerDto>?
)