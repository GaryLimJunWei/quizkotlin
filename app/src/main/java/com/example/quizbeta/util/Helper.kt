package com.example.quizbeta.util

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.quizbeta.ui.FirstPageActivity
import com.example.quizbeta.ui.auth.HomeActivity


fun Context.login()
{
    val intent = Intent(this, HomeActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        //IF YOU don't do this, when user press back button user will see the register again
    }
    startActivity(intent)
}

fun Context.logout()
{
    val intent = Intent(this, FirstPageActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        //IF YOU don't do this, when user press back button user will see the register again
    }
    startActivity(intent)
}