package com.example.testapp.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.ui.utils.SingleLiveEvent
import java.lang.Exception

abstract class BaseViewModel :ViewModel() {

    private val _message = SingleLiveEvent<String>()

    val message : LiveData<String> = _message

    fun showErrorMessage(error: Exception) {
        _message.value = error.message
    }
}