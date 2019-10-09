package com.example.quizbeta.ui.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog

import com.example.quizbeta.R
import com.example.quizbeta.ui.auth.LoginActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.reset_success_dialog.view.*


class EmployeeEditProfileFragment : Fragment()
{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee_edit_profile, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        emp_profile_update_save_changes_button.setOnClickListener {

            val dialog = AlertDialog.Builder(view.context)
            val dialogView = layoutInflater.inflate(R.layout.profile_updated_dialog,null)
            dialog.setView(dialogView)
            val mAlertDialog = dialog.show()
            dialogView.backBtn.setOnClickListener {
                mAlertDialog.dismiss()
                Intent(view.context,LoginActivity::class.java).also {
                    startActivity(it)
                }

            }
        }
    }


}
