package com.codingstuff.loginandsignup.ui.components

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.codingstuff.loginandsignup.*
import com.codingstuff.loginandsignup.databinding.ActivityDialogHerramientasBinding
import com.codingstuff.loginandsignup.databinding.DialogInputBinding

class dialogHerramientas(
    private val onSubmitClickListener:()->Unit
): DialogFragment() {

    private lateinit var binding: ActivityDialogHerramientasBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = ActivityDialogHerramientasBinding.inflate(LayoutInflater.from(context))

        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.podometroImage.setOnClickListener{
            startActivity(Intent(context, podome::class.java))
            dismiss()
        }
        binding.nutricionImage.setOnClickListener{
            startActivity(Intent(context,VisorWeb::class.java))
            dismiss()
        }
        binding.cardiacoImage.setOnClickListener{
            startActivity(Intent(context, Frecuencia::class.java))
            dismiss()
        }
        binding.musicButton.setOnClickListener{
            val music = musica(
                onSubmitClickListener = {
                }
            ).show(parentFragmentManager, "musica")
            dismiss()
        }


        val dialog= builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.setGravity(Gravity.CENTER)
        return dialog

    }
}