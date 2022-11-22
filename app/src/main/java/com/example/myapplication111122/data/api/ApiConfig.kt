package com.example.myapplication111122.data.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    private const val BASE_URL = "https://run.mocky.io/v3/"

    fun apiService(): ApiService = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient())
        .build()
        .create(ApiService::class.java)

    private fun okHttpClient() = OkHttpClient.Builder().addInterceptor(
        httpLoggingInterceptor()
    ).build()

    private fun httpLoggingInterceptor() = HttpLoggingInterceptor().setLevel(
        HttpLoggingInterceptor.Level.BODY
    )


}
