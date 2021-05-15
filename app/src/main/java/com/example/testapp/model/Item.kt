package com.example.testapp.model

sealed class Item {
    data class Manufacturer(
        var id: String,
        val brandName: String,
        val founderName: String,
        val foundationDate: String
    ) : Item()

    data class Car(val brandId: String, val modelName: String, val releaseDate: String) : Item()

    object LoadingIndicator : Item()
}