package com.example.myapplication.service

import com.example.myapplication.model.BookEntity
import com.example.myapplication.util.dto.ResponseStatusDTO
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface BookService {

    @GET("/book/list")
    suspend fun list(): List<BookEntity>

    @GET("/book/byId/{id}")
    suspend fun byId(@Path("id") id: String): BookEntity

    @POST("/book/add")
    suspend fun add(@Body book: BookEntity): ResponseStatusDTO

    @PUT("/book/update/{id}")
    suspend fun update(@Body book: BookEntity, @Path("id") id: String): ResponseStatusDTO

    @DELETE("/book/delete/{id}")
    suspend fun delete(@Path("id") id: String): ResponseStatusDTO
}