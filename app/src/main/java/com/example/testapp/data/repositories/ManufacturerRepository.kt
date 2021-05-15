package com.example.testapp.data.repositories

import com.example.testapp.data.source.RemoteDataSource
import com.example.testapp.model.Item

interface ManufacturerRepository {
    fun getManufacturers() : List<Item.Manufacturer>
}

class ManufacturerRepoImpl(private val remote: RemoteDataSource) : ManufacturerRepository {
    override fun getManufacturers(): List<Item.Manufacturer> {
        return remote.getManufacturers()
    }
}