package com.example.myapplication111122.data.models

import java.io.Serializable


data class FilterModel(
    val brand: String? = null,
    val price: String? = null,
    val size: String? = null
) : Serializable