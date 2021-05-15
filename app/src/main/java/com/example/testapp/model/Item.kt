package com.example.testapp.model

sealed class Item {
    data class Manufacturer(
        var id: String,
        val brandName: String,
        val founderNames: String,
        val foundationDate: Int
    ) : Item()

    data class Car(val brandId: String, val modelName: String, val releseDate: Int) : Item()

    object LoadingIndicator : Item()
}