package com.example.myapplication111122.data.repozitory

import com.example.myapplication111122.data.models.PhonesDto
import com.example.myapplication111122.data.api.ApiService

class PhonesRepository(private val apiService: ApiService) {

    suspend fun getPhonesDto(): PhonesDto {
        val response = apiService.getPhonesResponse()
        val bestSeller = response.bestSeller
        val homeStoreHotSale = response.homeStoreHotSale
        return PhonesDto(bestSeller = bestSeller, homeStoreHotSale = homeStoreHotSale)
    }


}