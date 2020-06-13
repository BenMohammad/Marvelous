package com.benmohammad.marvelous.di

import com.benmohammad.marvelous.repository.DetailRepository
import com.benmohammad.marvelous.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        MainRepository(get(), get(), get())
    }

    single{
        DetailRepository(get())
    }
}