package com.example.myapplication111122.data.api

import com.example.myapplication111122.data.models.PhonesDto
import retrofit2.http.GET


interface ApiService {

    @GET("/v3/654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getPhonesResponse(): PhonesDto

}