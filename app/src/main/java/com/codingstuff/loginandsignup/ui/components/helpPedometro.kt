package com.codingstuff.loginandsignup.ui.components

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.codingstuff.loginandsignup.databinding.ActivityHelpPedometroBinding

class helpPedometro(
    private val onSubmitClickListener:()->Unit
): DialogFragment() {
    private lateinit var binding: ActivityHelpPedometroBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = ActivityHelpPedometroBinding.inflate(LayoutInflater.from(context))
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)
        val dialog= builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.setGravity(Gravity.CENTER)
        binding.cerrarInfo.setOnClickListener{
            dialog.dismiss()
        }
        return dialog
    }
}