package com.example.quizbeta.network.reponses

import com.example.quizbeta.data.db.entities.User
import com.example.quizbeta.network.requests.LoginRequest

data class AuthResponse(
    val empId : String?,
    val loginRequest: LoginRequest,
    val user: User?
)
