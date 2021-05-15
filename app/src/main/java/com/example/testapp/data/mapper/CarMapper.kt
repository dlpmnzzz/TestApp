package com.example.testapp.data.mapper

import com.example.testapp.data.api.model.CarResponseEntity
import com.example.testapp.model.Item.Car

class CarMapper : Mapper<CarResponseEntity, Car> {
    override fun firstToSecond(first: CarResponseEntity): Car {
        return Car(first.brand_id, first.modelName, first.releaseDate)
    }
}