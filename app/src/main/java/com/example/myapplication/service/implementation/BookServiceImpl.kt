package com.example.myapplication.service.implementation

import android.util.Log
import com.example.myapplication.model.BookEntity
import com.example.myapplication.service.RetrofitInstanceObject
import com.example.myapplication.util.dto.ResponseStatusDTO
import com.google.gson.Gson
import retrofit2.HttpException


class BookServiceImpl private constructor() {
    companion object {
        val instance: BookServiceImpl by lazy { BookServiceImpl() }
    }

    suspend fun list(): List<BookEntity>? {
        return try {
            RetrofitInstanceObject.apiBook.list()
        } catch (e: Exception) {
            Log.e("API Error", "Error: ${e.message}")
            null
        }
    }

    suspend fun byId(id:String): BookEntity? {
        return try {
            RetrofitInstanceObject.apiBook.byId(id)
        } catch (e: Exception) {
            Log.e("API Error", "Error: ${e.message}")
            null
        }
    }

    suspend fun create(bookEntity: BookEntity): ResponseStatusDTO? {
        return try {
            RetrofitInstanceObject.apiBook.add(bookEntity)
        } catch (e: HttpException) {
            e.response()?.errorBody()?.let { errorBody ->
                return Gson().fromJson(errorBody.string(), ResponseStatusDTO::class.java)
            }
        } catch (e: Exception) { null }
    }

    suspend fun update(bookEntity: BookEntity, id:String): ResponseStatusDTO? {
        return try {
            RetrofitInstanceObject.apiBook.update(bookEntity, id)
        } catch (e: HttpException) {
            e.response()?.errorBody()?.let { errorBody ->
                return Gson().fromJson(errorBody.string(), ResponseStatusDTO::class.java)
            }
        } catch (e: Exception) { null }
    }

    suspend fun delete(id:String): ResponseStatusDTO? {
        return try {
            RetrofitInstanceObject.apiBook.delete(id)
        } catch (e: HttpException) {
            e.response()?.errorBody()?.let { errorBody ->
                return Gson().fromJson(errorBody.string(), ResponseStatusDTO::class.java)
            }
        } catch (e: Exception) { null }
    }
}