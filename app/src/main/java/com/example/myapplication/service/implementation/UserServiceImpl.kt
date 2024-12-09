package com.example.myapplication.service.implementation

import android.util.Log
import com.example.myapplication.model.UserEntity
import com.example.myapplication.service.RetrofitInstanceObject
import com.example.myapplication.util.dto.ResponseStatusDTO
import com.google.gson.Gson
import retrofit2.HttpException

class UserServiceImpl private constructor() {
    companion object {
        val instance: UserServiceImpl by lazy { UserServiceImpl() }
    }

    suspend fun list(): List<UserEntity>? {
        return try {
            RetrofitInstanceObject.apiUser.list()
        } catch (e: Exception) {
            Log.e("API Error", "Error: ${e.message}")
            null
        }
    }

    suspend fun byId(id:String): UserEntity? {
        return try {
            RetrofitInstanceObject.apiUser.byId(id)
        } catch (e: Exception) {
            Log.e("API Error", "Error: ${e.message}")
            null
        }
    }

    suspend fun create(userEntity: UserEntity): ResponseStatusDTO? {
        return try {
            RetrofitInstanceObject.apiUser.add(userEntity);
        } catch (e: HttpException) {
            e.response()?.errorBody()?.let { errorBody ->
                return Gson().fromJson(errorBody.string(), ResponseStatusDTO::class.java)
            }
        } catch (e: Exception) { null }
    }

    suspend fun update(bookEntity: UserEntity, id:String): ResponseStatusDTO? {
        return try {
            RetrofitInstanceObject.apiUser.update(bookEntity, id)
        } catch (e: HttpException) {
            e.response()?.errorBody()?.let { errorBody ->
                return Gson().fromJson(errorBody.string(), ResponseStatusDTO::class.java)
            }
        } catch (e: Exception) { null }
    }
}