package com.example.randomdataapp.framework.di

import com.example.randomdataapp.domain.usecase.GetUsersUseCase
import com.example.randomdataapp.domain.usecase.GetUsersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

   @Binds
   fun bindsGetUsersUseCase(useCase: GetUsersUseCaseImpl) : GetUsersUseCase
}