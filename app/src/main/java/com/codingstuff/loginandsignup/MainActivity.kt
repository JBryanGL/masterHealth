package com.codingstuff.loginandsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import com.bumptech.glide.Glide
import com.codingstuff.loginandsignup.databinding.ActivityMainBinding
import com.codingstuff.loginandsignup.databinding.ActivitySignInBinding
import com.firebase.ui.auth.data.model.User
import com.google.firebase.auth.FirebaseAuth
import java.util.concurrent.ThreadLocalRandom.current

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}