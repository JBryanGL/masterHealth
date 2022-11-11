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
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.codingstuff.loginandsignup.R
import com.codingstuff.loginandsignup.databinding.ActivityMusicaBinding
import com.codingstuff.loginandsignup.databinding.DialogInputBinding
import com.codingstuff.loginandsignup.visorMusic1
import com.codingstuff.loginandsignup.visorMusic2

class musica(
    private val onSubmitClickListener:()->Unit
): DialogFragment() {

    private lateinit var binding: ActivityMusicaBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = ActivityMusicaBinding.inflate(LayoutInflater.from(context))
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.youtubeImage.setOnClickListener{
            startActivity(Intent(context, visorMusic1::class.java))
            dismiss()
        }
        binding.spotifyImage.setOnClickListener{
            startActivity(Intent(context,visorMusic2::class.java))
            dismiss()
        }

        val dialog= builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.setGravity(Gravity.CENTER)
        return dialog
    }
}