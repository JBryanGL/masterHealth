package com.codingstuff.loginandsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Prestart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prestart)

        //Intento al boton de iniciar sesion
        val continuar = findViewById<Button> ( R.id.continuar )
        continuar.setOnClickListener {
            var continuar = Intent (this, Home :: class.java )
            startActivity ( continuar
            )
        }
    }
}