package com.hutech.grocery.koin

import com.hutech.grocery.data.Repository
import com.hutech.grocery.network.UrbanFreshService
import com.hutech.grocery.viewmodels.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule= module {
    single { UrbanFreshService.create() }

    single { Repository.getInstance(get()) }


    viewModel { DashboardViewModel(get())}
}

