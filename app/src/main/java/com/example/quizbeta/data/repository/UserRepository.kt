package com.example.quizbeta.data.repository

import com.example.quizbeta.data.db.AppDatabase
import com.example.quizbeta.data.db.entities.User
import com.example.quizbeta.network.MyApi
import com.example.quizbeta.network.reponses.AuthResponse
import com.example.quizbeta.network.reponses.SafeApiRequest
import com.example.quizbeta.network.requests.LoginRequest

class UserRepository(
    private val api: MyApi,
    private val db : AppDatabase
) : SafeApiRequest()
{

    suspend fun userLogin(empID:Int,request: LoginRequest) : AuthResponse
    {

        // Need adjust the parameter base on MyApi
        return apiRequest { api.userLogin(empID,request) }


    }

    suspend fun saveUser(user:User) = db.getUserDao().upsert(user)


    // Observing the liveData
    fun getUser() = db.getUserDao().getuser()
}