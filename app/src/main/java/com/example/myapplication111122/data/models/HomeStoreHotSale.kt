package com.example.myapplication111122.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HomeStoreHotSale(

    val id: Int?,
    @SerializedName("is_buy") val isBuy: Boolean?,
    @SerializedName("is_new") val isNew: Boolean?,
    val picture: String?,
    val subtitle: String?,
    val title: String?
)