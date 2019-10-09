package com.example.quizbeta.network.reponses

import com.example.quizbeta.util.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

abstract class SafeApiRequest
{
    suspend fun<T : Any> apiRequest(call :  suspend () -> Response<T>) : T
    {
        val response = call.invoke()
        if(response.isSuccessful)
        {
            return response.body()!!
        }

        else
        {
            val error = response.errorBody()?.string()
            val message = StringBuilder()
            error?.let {
                try
                {
                    // This "message" is the error message that are design inside the JSON file
                    message.append(JSONObject(it).getString("message"))

                }
                catch (e : JSONException) { }
                message.append("\n")

            }
            message.append("Error Code :  ${response.code()}")

            throw ApiException(message.toString())
        }
    }
}