package com.vladgrushevoy.geekhwthread

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter

class MyAdapter( private var primeNumbers: MutableList<Int>): Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.number_list,
                parent,
                false
            )
        )

    override fun getItemCount() = primeNumbers.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.prime.text = primeNumbers[position].toString()
    }

    fun addItem(number: Int) {
        primeNumbers.add(number)
        notifyItemInserted(primeNumbers.size)
    }
}