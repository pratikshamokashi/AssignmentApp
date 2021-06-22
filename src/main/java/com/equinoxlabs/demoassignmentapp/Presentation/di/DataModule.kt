package com.equinoxlabs.demoassignmentapp.Presentation.di

import com.equinoxlabs.demoassignmentapp.Data.Mapper.UserDataMapper
import com.equinoxlabs.demoassignmentapp.Presentation.view.userList.DataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val PostModule = module {
    viewModel { DataViewModel(get()) }
    factory { UserDataMapper() }

//    single { Navigator }
}