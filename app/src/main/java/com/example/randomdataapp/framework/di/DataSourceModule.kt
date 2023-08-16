package com.example.randomdataapp.framework.di

import com.example.randomdataapp.data.datasource.HomeRemoteDataSource
import com.example.randomdataapp.data.datasource.HomeRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindsHomeRemoteDataSource(dataSource: HomeRemoteDataSourceImpl) : HomeRemoteDataSource
}