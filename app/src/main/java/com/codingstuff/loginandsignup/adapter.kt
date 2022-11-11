package com.codingstuff.loginandsignup

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class adapter(val images:List<String>):RecyclerView.Adapter<viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return viewHolder(layoutInflater.inflate(R.layout.item_api,parent,false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item:String = images[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = images.size
}