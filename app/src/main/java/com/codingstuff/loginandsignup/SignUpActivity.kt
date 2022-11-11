package com.codingstuff.loginandsignup

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.codingstuff.loginandsignup.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
        binding.atras.setOnClickListener {
            startActivity(Intent(this, StartupActivity::class.java))
        }

        binding.button.setOnClickListener {
            val nombre = binding.usuarioET.text.toString()
            val email = binding.emailEt.text.toString()
            val password = binding.passET.text.toString()
            val conPassword = binding.confirmPassEt.text.toString()

            if (nombre.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && conPassword.isNotEmpty()) {
                registrarUsuario(
                    nombre,
                    email,
                    password,
                )
            } else {
                Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show()
            }

        }
        auth = Firebase.auth
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload()
        } else {

        }
    }

    private fun registrarUsuario(
        nombre: String,
        email: String,
        password: String
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val uid = user!!.uid
                    val map = hashMapOf(
                        "nombre" to nombre,
                        "correo" to email,
                        "contraseña" to password
                    )
                    val db = Firebase.firestore

                    db.collection("users").document(uid).set(map).addOnSuccessListener {
                        infoUser()
                        Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_SHORT).show()
                    }
                        .addOnFailureListener {
                            Toast.makeText(
                                this,
                                "Fallo al guardar la informacion",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                } else {
                    Toast.makeText(
                        this, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    private fun infoUser() {
        val infoUserIntent = Intent(this, Principal::class.java)
        startActivity(infoUserIntent)

    }

    private fun reload() {

    }
}