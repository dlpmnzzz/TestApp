package com.example.testapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.testapp.data.usecases.LoadManufacturerAndCars
import com.example.testapp.data.util.Result
import com.example.testapp.data.util.successOr
import com.example.testapp.model.Item
import com.example.testapp.ui.base.BaseViewModel

class HomeViewModel(private val getItemsUseCase: LoadManufacturerAndCars) : BaseViewModel() {
    private val _items = liveData {
        val result = getItemsUseCase(Unit)
        val items = result.successOr(emptyList())
        emit(items)
        if (result is Result.Error) {
            showErrorMessage(result.exception)
        }

    }

    val items : LiveData<List<Item>> = _items


}