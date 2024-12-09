package com.example.myapplication.util.dto

data class ResponseStatusDTO(
    val isSuccess: Boolean,
    val message: String,
    val errors: List<String>?
)
