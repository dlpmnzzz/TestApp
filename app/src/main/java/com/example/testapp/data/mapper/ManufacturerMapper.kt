package com.example.testapp.data.mapper

import com.example.testapp.data.api.model.ManufacturerResponseEntity
import com.example.testapp.model.Item

class ManufacturerMapper : Mapper<ManufacturerResponseEntity, Item.Manufacturer> {

    override fun firstToSecond(first: ManufacturerResponseEntity): Item.Manufacturer {
        return Item.Manufacturer(first.id ?: "", first.brand_name ?: "", first.founder_names?.get(0) ?: "", first.foundationDate ?: "")
    }
}