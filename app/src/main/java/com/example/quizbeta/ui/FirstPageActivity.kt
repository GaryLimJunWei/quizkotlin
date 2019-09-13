package com.example.quizbeta.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.example.quizbeta.R
import com.example.quizbeta.ui.auth.LoginActivity
import kotlinx.android.synthetic.main.activity_page_first.*

class FirstPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_first)

        // Function for the Spinner
        myCustomSpinner()

        // When Continue Button is Click
        ContinueButton()

    }

    fun ContinueButton()
    {
        continue_btn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    fun myCustomSpinner()
    {
        val myString = arrayOf("HR","Admin","Existing Employee","Guest User")
        spinner.adapter = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,myString)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@FirstPageActivity,myString[position],LENGTH_LONG).show()
            }

        }
    }

}
