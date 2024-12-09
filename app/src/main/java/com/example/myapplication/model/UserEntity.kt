package com.example.myapplication.model

data class UserEntity(
    val idUser: String,
    val username: String,
    val password: String,
    val fullName: String,
    val email: String,
    val role: String
)