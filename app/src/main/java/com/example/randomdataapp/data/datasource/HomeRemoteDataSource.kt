package com.example.randomdataapp.data.datasource

import com.example.randomdataapp.domain.models.UsersDTO

interface HomeRemoteDataSource {

    suspend fun getUsers() : List<UsersDTO>
}