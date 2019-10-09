package com.example.quizbeta.ui.auth

import com.example.quizbeta.data.db.entities.User

interface AuthListener
{
    fun onStarted()
    fun onSuccess(user:User)
    fun onFailure(message:String)
}
