package com.example.quizbeta.ui.auth

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.quizbeta.data.repository.UserRepository
import com.example.quizbeta.network.requests.LoginRequest
import com.example.quizbeta.ui.FirstPageActivity
import com.example.quizbeta.util.ApiException
import com.example.quizbeta.util.Coroutines

class AuthViewModel(
    private val repository: UserRepository
) : ViewModel()
{

    // 2 way Data Binding
     var empID : String ?= null
     var password : String ?= null
//    var request = LoginRequest(empID!!.toInt(),password)
    var authListener : AuthListener ?= null

    // To observe the user logged in
    fun getLoggedInUser() = repository.getUser()

    fun onLoginButtonClick(view: View)
    {

        Intent(view.context,HomeActivity::class.java).also {
            view.context.startActivity(it)
        }

//        authListener?.onStarted()
//        if(empID.toString().isNullOrEmpty())
//        {
//            authListener?.onFailure("Employee ID cannot be blank!")
//            return
//        }
//
//        if(password.isNullOrEmpty())
//        {
//            authListener?.onFailure("Please enter password!")
//            return
//        }
//
//        Coroutines.main{
//            try
//            {
//                val authResponse = repository.userLogin(empID?.toInt()!!,request)
//                authResponse.user?.let {
//                    authListener?.onSuccess(it)
//                    //Saving User into local database ( ROOM )
//                    repository.saveUser(it)
//                    return@main
//                }
//            }
//            catch (e : ApiException)
//            {
//                authListener?.onFailure(e.message!!)
//            }
//        }



                // Bad practise , it is creating tight coupling
//                val loginResponse = UserRepository().userLogin(empID!!,password!!,profileImg)
//
//                authListener?.onSuccess(loginResponse)



    }


    fun onForgetPasswordClick(view: View)
    {
            Intent(view.context,ForgetPasswordActivity::class.java).also {
                view.context.startActivity(it)
            }
    }

    fun onSwitchUserButtonClick(view: View)
    {
        Intent(view.context,FirstPageActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun onRegisterForNewEmployee(view: View)
    {
        Intent(view.context,RegisterPageActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun onStartTestButtonClick(view: View)
    {

    }








}