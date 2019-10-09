package com.example.quizbeta.data

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.quizbeta.R
import com.example.quizbeta.ui.ManageEmployeeActivity

class UserCustomAdapter(var context: Context, var employeeList : ArrayList<employeeList>) : BaseAdapter()
{
    private class ViewHolder(row:View?)
    {
        var emp_dp : ImageView
        var emp_name : TextView
        var manageaBtn : Button

        init
        {
            this.emp_name = row?.findViewById(R.id.emp_name) as TextView
            this.emp_dp = row?.findViewById(R.id.emp_dp) as ImageView
            this.manageaBtn = row?.findViewById(R.id.manage_account_btn) as Button
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        var view : View?
        var viewHolder : ViewHolder
        if(convertView == null)
        {
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.employeedblist,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }

        else
        {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var employeeList : employeeList = getItem(position) as employeeList
        viewHolder.emp_name.text = employeeList.name
        viewHolder.emp_dp.setImageResource(employeeList.image)

        viewHolder.manageaBtn.setOnClickListener {
                Intent(context,ManageEmployeeActivity::class.java).also {
                    context.startActivity(it)
                }
        }

        return view as View
    }

    override fun getItem(position: Int): Any
    {
        return employeeList.get(position)
    }

    override fun getItemId(position: Int): Long
    {
        return position.toLong()
    }

    override fun getCount(): Int
    {
        return employeeList.count()
    }

}