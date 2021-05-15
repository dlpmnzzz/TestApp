package com.example.testapp.data.api

import com.example.testapp.data.api.model.CarResponse
import com.example.testapp.data.api.model.ManufacturerResponse
import com.example.testapp.data.api.model.ManufacturerResponseEntity
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun getManufactures(@Url url: String) : ManufacturerResponse

    @GET
    suspend fun getCars(@Url url: String) : CarResponse
}