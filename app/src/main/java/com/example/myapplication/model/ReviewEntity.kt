package com.example.myapplication.model

data class ReviewEntity(
    val idReview: String,
    val idBook: String,
    val idUser: String,
    val stars: Int,
    val comment: String,
    val date: String
)