package com.example.myapplication.model

data class BookEntity(
    val idBook: String,
    val title: String,
    val isbn: String,
    val description: String,
    val editorial: String,
    val author: String,
    val urlImage: String,
    val urlBook: String,
    val gender: String
)
