package com.example.quizbeta.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.quizbeta.R
import kotlinx.android.synthetic.main.activity_register_page.*
import kotlinx.android.synthetic.main.reset_success_dialog.view.*

class RegisterPageActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        myCustomSpinner()

        register_button.setOnClickListener {
            registerButton()
        }
    }

    fun myCustomSpinner()
    {
        val searchByString = arrayOf("HR","Developer","Manager")
        val spinner = findViewById<Spinner>(R.id.register_spinner)

        if (spinner != null)
        {
            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, searchByString)
            spinner.adapter = arrayAdapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
            {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long)
                {
                    Toast.makeText(this@RegisterPageActivity, getString(R.string.selected_item) + " " + searchByString[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>)
                {
                    // Code to perform some action when nothing is selected
                }
            }
        }


    }

    fun registerButton()
    {
        val dialog = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.register_success_dialog,null)
        dialog.setView(dialogView)
        val mAlertDialog = dialog.show()
        dialogView.backBtn.setOnClickListener {
            mAlertDialog.dismiss()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
