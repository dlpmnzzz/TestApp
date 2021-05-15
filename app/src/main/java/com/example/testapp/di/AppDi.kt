package com.example.testapp.di

import com.example.testapp.data.repositories.CarRepoImpl
import com.example.testapp.data.repositories.CarRepository
import com.example.testapp.data.repositories.ManufacturerRepoImpl
import com.example.testapp.data.repositories.ManufacturerRepository
import com.example.testapp.data.source.RemoteDataSource
import com.example.testapp.data.source.RemoteImpl
import com.example.testapp.data.usecases.LoadManufacturerAndCars
import com.example.testapp.ui.home.HomeViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    viewModel { HomeViewModel(get()) }

    single { LoadManufacturerAndCars(get(), get(), Dispatchers.IO) }
    single<CarRepository> { CarRepoImpl(get()) }
    single<ManufacturerRepository> { ManufacturerRepoImpl(get()) }
    single<RemoteDataSource> { RemoteImpl() }
}