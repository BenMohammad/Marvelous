package com.benmohammad.marvelous.di

import com.benmohammad.marvelous.view.ui.details.PosterDetailViewModel
import com.benmohammad.marvelous.view.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel{ PosterDetailViewModel(get()) }
}