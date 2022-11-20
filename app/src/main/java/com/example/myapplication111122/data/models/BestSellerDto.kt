package com.example.myapplication111122.data.models

import java.io.Serializable

data class BestSellerDto(
    val discount_price: Int?=null,
    val id: Int?=null,
    val is_favorites: Boolean?=null,
    val picture: String?=null,
    val price_without_discount: Int?=null,
    val title: String?=null
):Serializable