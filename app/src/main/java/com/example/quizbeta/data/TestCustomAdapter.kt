package com.example.quizbeta.data

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startForegroundService
import com.example.quizbeta.R
import com.example.quizbeta.ui.auth.LoginActivity
import com.example.quizbeta.util.toast
import kotlinx.android.synthetic.main.start_test_dialog.view.*


lateinit var radioGroup : RadioGroup

class TestCustomAdapter(var context: Context, var testList : ArrayList<testList>) : BaseAdapter()
{



    private class ViewHolder(row:View?)
    {
        var testName : TextView
        var questionNumber : TextView
        var timeLimit : TextView
        var attempts : TextView
        var startTest : Button

        init
        {
            // CREATE THE LAYOUT FIRST THEN ADD THE ID WITH THE TEXTVIEW AND ALL HERE USING FINDVIEWBYID

            this.testName = row?.findViewById(R.id.testName) as TextView
            this.questionNumber = row?.findViewById(R.id.questionNumber) as TextView
            this.timeLimit = row?.findViewById(R.id.timeLimit) as TextView
            this.attempts = row?.findViewById(R.id.attempts) as TextView
            this.startTest = row?.findViewById(R.id.startTestBtn) as Button
        }

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        var view : View?
        var viewHolder : ViewHolder
        if(convertView == null)
        {
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.testlist,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }

        else
        {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var testList : testList = getItem(position) as testList
        viewHolder.testName.text = testList.testName
        viewHolder.questionNumber.text = testList.numberOfQuestions
        viewHolder.timeLimit.text = testList.timeLimit
        viewHolder.attempts.text = testList.attempts
        viewHolder.startTest.setOnClickListener {

            customDialog()
        }


        return view as View
    }

    override fun getItem(position: Int): Any
    {
        return testList.get(position)
    }

    override fun getItemId(position: Int): Long
    {
        return position.toLong()
    }

    override fun getCount(): Int
    {
        return testList.count()
    }

    fun customDialog()
    {
        val dialog = AlertDialog.Builder(context)
        val dialogView = inflate(context,R.layout.start_test_dialog,null)
        dialog.setView(dialogView)
        val mAlertDialog = dialog.show()
        dialogView.startTestDialogButton.setOnClickListener {
            mAlertDialog.dismiss()
            Intent(context,LoginActivity::class.java).also {
                        context.startActivity(it)

            }

            }
    }
}


