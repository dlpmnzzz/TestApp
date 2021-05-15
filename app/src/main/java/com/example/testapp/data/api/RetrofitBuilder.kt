package com.example.testapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val MANUFACTURER_URL = "https://www.mocky.io/v2/5db959e43000005a005ee206/"

    private fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(MANUFACTURER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}