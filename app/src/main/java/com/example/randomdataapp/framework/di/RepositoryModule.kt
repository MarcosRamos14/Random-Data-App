package com.example.randomdataapp.framework.di

import com.example.randomdataapp.data.repository.HomeRepository
import com.example.randomdataapp.data.repository.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsHomeRepository(repository: HomeRepositoryImpl) : HomeRepository
}