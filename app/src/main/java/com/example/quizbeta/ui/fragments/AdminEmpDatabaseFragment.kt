package com.example.quizbeta.ui.fragments


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.quizbeta.R
import com.example.quizbeta.data.UserCustomAdapter
import com.example.quizbeta.data.db.entities.User
import com.example.quizbeta.data.employeeList
import kotlinx.android.synthetic.main.admin_employee_db.*
import java.util.*
import kotlin.collections.ArrayList


class AdminEmpDatabaseFragment : Fragment(),Filterable
{
    override fun getFilter(): Filter
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var listView: ListView
    lateinit var userList : MutableList<User>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.admin_employee_db, container, false)

        listView = view.findViewById(R.id.listview_for_employee)

        var arrListExample : ArrayList<employeeList> = ArrayList()

        arrListExample.add(employeeList(R.drawable.ic_boy,"Jerret"))
        arrListExample.add(employeeList(R.drawable.ic_boy,"Amanda"))
        arrListExample.add(employeeList(R.drawable.ic_boy,"Jasmine"))
        arrListExample.add(employeeList(R.drawable.ic_boy,"Gabriel"))
        arrListExample.add(employeeList(R.drawable.ic_boy,"Adam"))
        arrListExample.add(employeeList(R.drawable.ic_boy,"KK ling"))
        arrListExample.add(employeeList(R.drawable.ic_boy,"asdasd ling"))



        listView.adapter = UserCustomAdapter(context!!,arrListExample)
        userList = mutableListOf()



        myCustomSpinner(view)
        return view

    }


    /*
        NOTE : It is important to pass the view in the parameter, as kotlin cannot tolerate null pointer exception.
        Hence it is necessary to pass the view in order to avoid null pointer exception!
     */
    fun myCustomSpinner(view: View)
    {
        val searchByString = arrayOf("Name","Employee ID")
        val activeOrNotString = arrayOf("Active","Inactive","(Clear Search)")
        val spinner = view.findViewById<Spinner>(R.id.search_by_spinner)
        val activeSpinner = view.findViewById<Spinner>(R.id.activeOrNotSpinner)

        if (spinner != null) {
            val arrayAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, searchByString)
            spinner.adapter = arrayAdapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    Toast.makeText(context, getString(R.string.selected_item) + " " + searchByString[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Code to perform some action when nothing is selected
                }
            }
        }

        if (activeSpinner != null) {
            val arrayAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, activeOrNotString)
            activeSpinner.adapter = arrayAdapter

            activeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    Toast.makeText(context, getString(R.string.selected_item) + " " + activeOrNotString[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Code to perform some action when nothing is selected
                }
            }
        }

    }







}
