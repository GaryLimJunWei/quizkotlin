package com.example.quizbeta.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.quizbeta.R
import kotlinx.android.synthetic.main.activity_forget_password.*
import kotlinx.android.synthetic.main.reset_success_dialog.view.*

class ForgetPasswordActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

       cancel_button.setOnClickListener {
           val intent = Intent(this,LoginActivity::class.java)
           startActivity(intent)
       }

        submit_button.setOnClickListener {

            val dialog = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.reset_success_dialog,null)
            dialog.setView(dialogView)
            val mAlertDialog = dialog.show()
            dialogView.backBtn.setOnClickListener {
                mAlertDialog.dismiss()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

        }

    }
}
