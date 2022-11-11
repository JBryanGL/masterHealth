package com.codingstuff.loginandsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.firebase.ui.auth.AuthUI

class logOut : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            AuthUI.getInstance().signOut(this).addOnSuccessListener {
                startActivity(Intent(this, StartupActivity::class.java))

                Toast.makeText(this,"Salio de su sesión", Toast.LENGTH_SHORT).show()

                finish()
            }.addOnFailureListener {
                Toast.makeText(this,"Ocurrio un  error ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }
}