package com.example.myapplication111122.data.models

import java.io.Serializable

data class PhonesDto(
    val bestSeller: List<BestSellerDto>?,
    val homeStoreHotSale: List<HomeStoreHotSale>?
) : Serializable