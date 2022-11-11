package com.codingstuff.loginandsignup.ui.components

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.codingstuff.loginandsignup.Principal
import com.codingstuff.loginandsignup.R
import com.codingstuff.loginandsignup.databinding.ActivityDialog2Binding
import kotlinx.coroutines.NonCancellable.cancel
import kotlin.math.log
import kotlin.math.roundToInt
class dialog2(
    private val onSubmitClickListener:(Double)->Unit
): DialogFragment() {

    private lateinit var binding: ActivityDialog2Binding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = ActivityDialog2Binding.inflate(LayoutInflater.from(context))
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)


        binding.btnConvertir.setOnClickListener{
            var convertir = binding.centimentros.text.toString().toDouble()*0.39370
            var texto = binding.pulgadas
            texto.text = convertir.toString().toDouble().roundToInt().toString()+"\""
        }

        binding.btnMujer.setOnClickListener{
            onSubmitClickListener.invoke(
                (163.205)
                        *log(binding.abdomenMujer.text.toString().toDouble()+binding.caderaET.text.toString().toDouble()-binding.cuelloMujer.text.toString().toDouble(),10.0)
                        -(97.684)
                        *log(binding.alturaMujer.text.toString().toDouble(),10.0)-78.387)
            dismiss()
        }

        binding.btnHombre.setOnClickListener{
            onSubmitClickListener.invoke(
                (86.010)
                        *log(binding.abdomenET.text.toString().toDouble()-binding.cuelloHombre.text.toString().toDouble(),10.0)
                        -(70.041)
                        *log(binding.alturaHombre.text.toString().toDouble(),10.0)+36.76)
            dismiss()
        }

        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.setGravity(Gravity.CENTER)
        binding.atrasDialog.setOnClickListener{
            dialog.dismiss()
        }
        return dialog
    }
}
