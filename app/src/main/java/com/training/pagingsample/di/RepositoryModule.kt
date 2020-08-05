package com.training.pagingsample.di

import com.training.pagingsample.data.network.MovieAppService
import com.training.pagingsample.data.repository.Repository
import org.koin.dsl.module

val repositoryModule = module {
    single { createRepository(get()) }
}

fun createRepository(
    movieAppService: MovieAppService
) : Repository = Repository(movieAppService)