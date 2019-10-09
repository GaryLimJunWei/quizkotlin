package com.example.quizbeta.ui.auth


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.quizbeta.R
import com.example.quizbeta.data.db.AppDatabase
import com.example.quizbeta.data.db.entities.User
import com.example.quizbeta.data.repository.UserRepository
import com.example.quizbeta.databinding.ActivityLoginBinding
import com.example.quizbeta.network.MyApi
import com.example.quizbeta.util.hide
import com.example.quizbeta.util.show
import com.example.quizbeta.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),AuthListener{


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        val api = MyApi()
        val db = AppDatabase(this)
        val repository = UserRepository(api,db)
        val factory = AuthViewModelFactory(repository)

        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewmodel = ViewModelProviders.of(this,factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewmodel

        viewmodel.authListener = this

        viewmodel.getLoggedInUser().observe(this, Observer { user ->
            if(user != null)
            {
                Intent(this,HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })


    }

    override fun onStarted()
    {
        progressbar.show()
    }

    override fun onSuccess(user:User)
    {
        progressbar.hide()
    }

    override fun onFailure(message: String)
    {
        progressbar.hide()
        toast(message)
    }
}
