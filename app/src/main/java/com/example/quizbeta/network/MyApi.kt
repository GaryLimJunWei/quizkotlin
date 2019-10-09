package com.example.quizbeta.network

import com.example.quizbeta.network.reponses.AuthResponse
import com.example.quizbeta.network.requests.LoginRequest
import com.example.quizbeta.network.requests.LoginRequested
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface MyApi
{

    @POST("backendapi/admin/{adminid}/login")
    suspend fun userLogin(
        @Path("adminid") adminid: Int,
        @Body request: LoginRequest
    ) : Response<AuthResponse>

    companion object
    {
        operator fun invoke() : MyApi
        {
            return Retrofit.Builder()
                .baseUrl("http://192.168.200.200:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}