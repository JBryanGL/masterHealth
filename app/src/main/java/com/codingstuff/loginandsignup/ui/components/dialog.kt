package com.codingstuff.loginandsignup.ui.components

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.fragment.app.DialogFragment
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import com.codingstuff.loginandsignup.Home
import com.codingstuff.loginandsignup.Principal
import com.codingstuff.loginandsignup.R
import com.codingstuff.loginandsignup.databinding.DialogInputBinding


class dialog(
    private val onSubmitClickListener:(Float)->Unit
):DialogFragment() {

    private lateinit var binding: DialogInputBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogInputBinding.inflate(LayoutInflater.from(context))

       // setupButton()
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.cerrarInfo.setOnClickListener{
            onSubmitClickListener.invoke(binding.litrosET.text.toString().toFloat())
            dismiss()
        }

        val dialog= builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.setGravity(Gravity.CENTER)
        return dialog
    }
}