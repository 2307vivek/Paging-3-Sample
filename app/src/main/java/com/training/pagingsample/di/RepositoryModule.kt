package com.training.pagingsample.di

import com.training.pagingsample.data.network.Api
import com.training.pagingsample.data.repository.Repository
import org.koin.dsl.module

val repositoryModule = module {
    single { createRepository(get()) }
}

fun createRepository(
    service: Api
) : Repository = Repository(service)