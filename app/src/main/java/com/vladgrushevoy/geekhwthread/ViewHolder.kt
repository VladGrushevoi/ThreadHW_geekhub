package com.vladgrushevoy.geekhwthread

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.number_list.view.*

class MyViewHolder(view: View) :
    RecyclerView.ViewHolder(view) {
    val prime: TextView = view.prime_number
}