package com.example.randomdataapp.framework.di

import com.example.randomdataapp.domain.usecase.base.AppCoroutinesDispatchers
import com.example.randomdataapp.domain.usecase.base.CoroutinesDispatchers
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CoroutinesModule {

    @Binds
    fun bindDispatchers(dispatchers: AppCoroutinesDispatchers) : CoroutinesDispatchers
}