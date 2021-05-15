package com.example.testapp.data.mapper

interface Mapper<F, S> {
    fun firstToSecond(first: F) : S
}