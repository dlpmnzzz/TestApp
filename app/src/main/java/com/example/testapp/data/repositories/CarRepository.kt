package com.example.testapp.data.repositories

import com.example.testapp.data.source.RemoteDataSource
import com.example.testapp.model.Item

interface CarRepository {
    fun getCars() : List<Item.Car>
}

class CarRepoImpl(private val remote: RemoteDataSource) : CarRepository {
    override fun getCars(): List<Item.Car> {
        return remote.getCars()
    }
}