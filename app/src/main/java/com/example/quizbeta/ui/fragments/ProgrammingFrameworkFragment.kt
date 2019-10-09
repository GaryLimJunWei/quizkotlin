package com.example.quizbeta.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import com.example.quizbeta.R
import com.example.quizbeta.data.TestCustomAdapter
import com.example.quizbeta.data.db.entities.Test
import com.example.quizbeta.data.testList
import com.example.quizbeta.util.toast
import kotlinx.android.synthetic.main.testlist.*


class ProgrammingFrameworkFragment : Fragment()
{



    lateinit var listView: ListView
    lateinit var TestList : MutableList<Test>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val view = inflater.inflate(R.layout.fragment_programming_framework, container, false)
        listView = view.findViewById(R.id.testNameListView)

        var arrListExample : ArrayList<testList> = ArrayList()

        //var testName:String,var numberOfQuestions:Int,var timeLimit:Int,var attempts:Int

        arrListExample.add(testList("Core Java Test", "10", "30 minutes", "0/2"))
        arrListExample.add(testList("MySQL Test", "10", "30 minutes", "0/2"))
        arrListExample.add(testList("Python Test", "10", "30 minutes", "0/2"))
        arrListExample.add(testList("JavaScript Test", "10", "30 minutes", "0/2"))
        arrListExample.add(testList("Android Development Test", "10", "30 minutes", "0/2"))
        arrListExample.add(testList("Kotlin Test", "10", "30 minutes", "0/2"))
        arrListExample.add(testList("React JS Test", "10", "30 minutes", "0/2"))
        arrListExample.add(testList("React Native Test", "10", "30 minutes", "0/2"))
        arrListExample.add(testList("IOS Test", "10", "30 minutes", "0/2"))

        listView.adapter = TestCustomAdapter(context!!,arrListExample)

        TestList = mutableListOf()

        return view
    }



}
