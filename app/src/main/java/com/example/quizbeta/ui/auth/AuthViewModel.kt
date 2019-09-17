package com.example.quizbeta.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel()
{
    var empID : Int ?= null
    var password : String ?= null

    var authListener : AuthListener ?= null

    fun onLoginButtonClick(view: View)
    {
        if(empID!!.equals(null) || password.isNullOrEmpty())
        {
            authListener?.onFailure("Invalid ID or password")
            return
        }

        authListener?.onSuccess()


    }



}