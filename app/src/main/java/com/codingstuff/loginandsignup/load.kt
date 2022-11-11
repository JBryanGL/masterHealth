package com.codingstuff.loginandsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.coroutines.delay

class load : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_LoginAndSignUp)
        super.onCreate(savedInstanceState)
        startActivity(Intent(this,StartupActivity::class.java))
    }
}