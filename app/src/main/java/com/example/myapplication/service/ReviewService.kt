package com.example.myapplication.service

import com.example.myapplication.model.ReviewEntity
import com.example.myapplication.util.dto.ResponseStatusDTO
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ReviewService {
    @GET("/review/list")
    suspend fun list(): List<ReviewEntity>

    @GET("/review/byId/{id}")
    suspend fun byId(@Path("id") id: String): ReviewEntity

    @POST("/review/add")
    suspend fun add(@Body review: ReviewEntity): ResponseStatusDTO

    @PUT("/review/update/{id}")
    suspend fun update(@Body review: ReviewEntity, @Path("id") id: String): ResponseStatusDTO

    @DELETE("/review/delete/{id}")
    suspend fun delete(@Path("id") id: String): ResponseStatusDTO
}