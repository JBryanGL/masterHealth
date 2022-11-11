package com.codingstuff.loginandsignup

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.codingstuff.loginandsignup.databinding.ItemApiBinding
import com.squareup.picasso.Picasso

class viewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val binding = ItemApiBinding.bind(view)

    fun bind(image:String){
        Picasso.get().load(image).into(binding.imageApi)

    }
}