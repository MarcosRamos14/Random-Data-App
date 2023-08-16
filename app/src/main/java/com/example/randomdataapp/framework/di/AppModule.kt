package com.example.randomdataapp.framework.di

import com.example.randomdataapp.framework.imageLoader.GlideImageLoader
import com.example.randomdataapp.framework.imageLoader.ImageLoader
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
interface AppModule {

    @Binds
    fun bindsImageLoader(imageLoader: GlideImageLoader) : ImageLoader
}