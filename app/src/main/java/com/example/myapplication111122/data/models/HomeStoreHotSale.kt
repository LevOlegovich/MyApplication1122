package com.example.myapplication111122.data.models

import java.io.Serializable

data class HomeStoreHotSale(
    val id: Int? = null,
    val isBuy: Boolean? = null,
    val isNew: Boolean? = null,
    val picture: String? = null,
    val subtitle: String? = null,
    val title: String? = null
) : Serializable