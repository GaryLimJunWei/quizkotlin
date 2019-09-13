package com.example.quizbeta.ui.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.annotation.LayoutRes
import androidx.fragment.app.FragmentActivity

import com.example.quizbeta.R
import com.example.quizbeta.data.db.entities.User


class AdminEmpDatabaseFragment : Fragment()
{

    lateinit var listView: ListView
    lateinit var userList : MutableList<User>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.admin_employee_db, container, false)


        listView = view.findViewById(R.id.listview)

        userList = mutableListOf()

        /*

                I am trying to add a custom Listview which i created at employeedblist.xml inside my layout
                and the listview is inside admin_employee_db.xml

         */


        return view

    }







}
