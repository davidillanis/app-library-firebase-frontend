package com.example.myapplication.service.implementation

import android.util.Log
import com.example.myapplication.model.ReviewEntity
import com.example.myapplication.service.RetrofitInstanceObject
import com.example.myapplication.util.dto.ResponseStatusDTO
import com.google.gson.Gson
import retrofit2.HttpException


class ReviewServiceImpl private constructor() {
    companion object {
        val instance: ReviewServiceImpl by lazy { ReviewServiceImpl() }
    }

    suspend fun list(): List<ReviewEntity>? {
        return try {
            RetrofitInstanceObject.apiReview.list()
        } catch (e: Exception) {
            Log.e("API Error", "Error: ${e.message}")
            null
        }
    }

    suspend fun byId(id:String): ReviewEntity? {
        return try {
            RetrofitInstanceObject.apiReview.byId(id)
        } catch (e: Exception) {
            Log.e("API Error", "Error: ${e.message}")
            null
        }
    }

    suspend fun create(review: ReviewEntity): ResponseStatusDTO? {
        return try {
            RetrofitInstanceObject.apiReview.add(review);
        } catch (e: HttpException) {
            e.response()?.errorBody()?.let { errorBody ->
                return Gson().fromJson(errorBody.string(), ResponseStatusDTO::class.java)
            }
        } catch (e: Exception) { null }
    }

    suspend fun update(review: ReviewEntity, id:String): ResponseStatusDTO? {
        return try {
            RetrofitInstanceObject.apiReview.update(review, id)
        } catch (e: HttpException) {
            e.response()?.errorBody()?.let { errorBody ->
                return Gson().fromJson(errorBody.string(), ResponseStatusDTO::class.java)
            }
        } catch (e: Exception) { null }
    }
}