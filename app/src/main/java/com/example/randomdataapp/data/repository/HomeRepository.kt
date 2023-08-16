package com.example.randomdataapp.data.repository

import com.example.randomdataapp.domain.models.UsersDTO

interface HomeRepository {

    suspend fun getUsers() : List<UsersDTO>
}