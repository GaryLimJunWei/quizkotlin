package com.example.quizbeta.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizbeta.R
import java.util.*
import kotlin.collections.ArrayList

class SearchAdapter(ctx: Context, private val imageModelArrayList: ArrayList<SearchModel>) :
    RecyclerView.Adapter<SearchAdapter.MyViewHolder>() {

    private val inflater: LayoutInflater
    private val arraylist: ArrayList<SearchModel>

    init {

        inflater = LayoutInflater.from(ctx)
        this.arraylist = ArrayList<SearchModel>()
        this.arraylist.addAll(this.imageModelArrayList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.MyViewHolder {

        val view = inflater.inflate(R.layout.admin_employee_db, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchAdapter.MyViewHolder, position: Int) {

        holder.time.setText(imageModelArrayList[position].getNames())
    }

    override fun getItemCount(): Int {
        return imageModelArrayList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var time: TextView

        init {

            time = itemView.findViewById(R.id.search_text) as TextView
        }

    }

    // Filter Class
    fun filter(charText: String) {
        var charText = charText
        charText = charText.toLowerCase(Locale.getDefault())
        this.imageModelArrayList.clear()
        if (charText.length == 0) {
            this.imageModelArrayList.addAll(arraylist)
        } else {
            for (wp in arraylist) {
                if (wp.getNames().toLowerCase(Locale.getDefault()).contains(charText)) {
                    this.imageModelArrayList.add(wp)
                }
            }
        }
        notifyDataSetChanged()
    }

}