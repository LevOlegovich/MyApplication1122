package com.example.myapplication111122.data.repozitory

import android.util.Log
import com.example.myapplication111122.data.api.ApiService
import com.example.myapplication111122.data.models.PhonesDto

class PhonesRepository(private val apiService: ApiService) {

    suspend fun getPhonesDto(): PhonesDto {
        Log.d("PhonesRepository: ", apiService.toString())
        val response = apiService.getPhonesResponse()
        Log.d("PhonesRepository: ", response.toString())

        val bestSeller = response.bestSeller
        val homeStoreHotSale = response.homeStoreHotSale
        return PhonesDto(bestSeller = bestSeller, homeStoreHotSale = homeStoreHotSale)
    }


}