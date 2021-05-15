package com.example.testapp.data.source

import com.example.testapp.data.NetworkUtils
import com.example.testapp.data.api.ApiService
import com.example.testapp.data.mapper.CarMapper
import com.example.testapp.data.mapper.ManufacturerMapper
import com.example.testapp.model.Item

interface RemoteDataSource {
    suspend fun getCars() : List<Item.Car>
    suspend fun getManufacturers() : List<Item.Manufacturer>
}

class RemoteImpl(
    private val apiService: ApiService,
    private val manufacturereMapper: ManufacturerMapper,
    private val carMapper: CarMapper,
    private val networkUtils: NetworkUtils
) : RemoteDataSource {

    override suspend fun getCars(): List<Item.Car> {
        if (!networkUtils.hasNetworkConnection()) {
            error("There is no internet connection")
        }
        val response = apiService.getCars(CAR_URL)
        val items = response.data
        return items.map { carMapper.firstToSecond(it) }
    }

    override suspend fun getManufacturers(): List<Item.Manufacturer> {
        if (!networkUtils.hasNetworkConnection()) {
            error("There is no internet connection")
        }
        val response = apiService.getManufactures(MANUFACTURER_URL)
        val responseItems = response.data
        return responseItems?.map { manufacturereMapper.firstToSecond(it) } ?: emptyList()
    }

    companion object {
        private const val CAR_URL = "https://www.mocky.io/v2/5db9630530000095005ee272/"
        private const val MANUFACTURER_URL = "https://www.mocky.io/v2/5db959e43000005a005ee206/"
    }
}
