package com.example.myapplication.service

import com.example.myapplication.model.UserEntity
import com.example.myapplication.util.dto.AuthLoginDTO
import com.example.myapplication.util.dto.ResponseStatusDTO
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserService {
    @GET("/user/list")
    suspend fun list(): List<UserEntity>

    @GET("/user/byId/{id}")
    suspend fun byId(@Path("id") id: String): UserEntity

    @POST("/user/add")
    suspend fun add(@Body user: UserEntity): ResponseStatusDTO

    @POST("/user/login")
    suspend fun login(@Body auth: AuthLoginDTO): ResponseStatusDTO

    @PUT("/user/update/{id}")
    suspend fun update(@Body book: UserEntity, @Path("id") id: String): ResponseStatusDTO

    @DELETE("/user/delete/{id}")
    suspend fun delete(@Path("id") id: String): ResponseStatusDTO
}