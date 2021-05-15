package com.example.testapp.data.usecases

import com.example.testapp.data.repositories.CarRepository
import com.example.testapp.data.repositories.ManufacturerRepository
import com.example.testapp.model.Item
import kotlinx.coroutines.CoroutineDispatcher

class LoadManufacturerAndCars(
    private val carRepo: CarRepository,
    private val manufacturerRepo: ManufacturerRepository,
    dispatcher: CoroutineDispatcher
) : UseCase<Unit, List<Item>>(dispatcher) {

    override suspend fun execute(parameters: Unit): List<Item> {
        val manufacturers = manufacturerRepo.getManufacturers()
        val cars = carRepo.getCars()
        val result = mutableListOf<Item>()
        for (item in manufacturers) {
            result.add(item)
            result.addAll(cars.filter { it.brandId == item.id })
        }
        return result
    }
}