package com.codingstuff.loginandsignup.ui.components

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.codingstuff.loginandsignup.R
import com.codingstuff.loginandsignup.StartupActivity
import com.codingstuff.loginandsignup.databinding.ActivityDialog3Binding
import com.codingstuff.loginandsignup.databinding.DialogInputBinding
import com.codingstuff.loginandsignup.logOut
import com.firebase.ui.auth.AuthUI

class dialog3(
    private val onSubmitClickListener:()->Unit
):DialogFragment() {

    private lateinit var binding: ActivityDialog3Binding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = ActivityDialog3Binding.inflate(LayoutInflater.from(context))

        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.cerrarTodo.setOnClickListener{
            startActivity(Intent(context,logOut::class.java))
            dismiss()
        }

        val dialog= builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.setGravity(Gravity.CENTER)
        binding.btnClose.setOnClickListener{
            dialog.dismiss()
        }
        return dialog
    }
}