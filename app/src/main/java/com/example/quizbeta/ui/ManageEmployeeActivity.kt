package com.example.quizbeta.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizbeta.R
import kotlinx.android.synthetic.main.activity_manage_employee.*

class ManageEmployeeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_employee)

        backBtn_Manage_Emp.setOnClickListener {
            finish()
        }

    }
}
