package com.example.testapp.data.source

import com.example.testapp.model.Item

interface RemoteDataSource {
    fun getCars() : List<Item.Car>
    fun getManufacturers() : List<Item.Manufacturer>
}

class RemoteImpl() : RemoteDataSource {
    override fun getCars(): List<Item.Car> {
        return listOf(
            Item.Car("test1", "testName1", "1988"),
            Item.Car("test2", "testName2", "1966"),
            Item.Car("test1", "testName2", "1966"),
            Item.Car("test3", "testName3", "1977"),
            Item.Car("test2", "testName3", "1977"),
        )
    }

    override fun getManufacturers(): List<Item.Manufacturer> {
        return listOf(
            Item.Manufacturer("test1", "brandName1", "founderName1", "1950"),
            Item.Manufacturer("test2", "brandName2", "founderName2", "1960"),
            Item.Manufacturer("test3", "brandName3", "founderName3", "1930"),
        )
    }

}
