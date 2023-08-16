package com.example.randomdataapp.data.datasource

import com.example.randomdataapp.domain.models.UsersDTO
import com.example.randomdataapp.data.response.toUsersModel
import com.example.randomdataapp.framework.network.RandomDataApi
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(
    private val randomData: RandomDataApi
) : HomeRemoteDataSource {

    override suspend fun getUsers(): List<UsersDTO> {
        return randomData.getUsers().map {
            it.toUsersModel()
        }
    }
}