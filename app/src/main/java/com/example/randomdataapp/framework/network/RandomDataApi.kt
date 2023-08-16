package com.example.randomdataapp.framework.network

import com.example.randomdataapp.data.response.UsersResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomDataApi {

    @GET("users")
    suspend fun getUsers(@Query("size") size: Int = 100) : List<UsersResponseDTO>
}