package com.example.randomdataapp.data.repository

import com.example.randomdataapp.data.datasource.HomeRemoteDataSource
import com.example.randomdataapp.domain.models.UsersDTO
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val remoteDataSource: HomeRemoteDataSource
) : HomeRepository {

    override suspend fun getUsers(): List<UsersDTO> {
        return remoteDataSource.getUsers()
    }
}