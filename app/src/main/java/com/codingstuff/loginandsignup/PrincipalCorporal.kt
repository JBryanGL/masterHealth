package com.codingstuff.loginandsignup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class PrincipalCorporal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_corporal)

        val home = findViewById<Button>(R.id.atras)
        home.setOnClickListener{
            var home = Intent(this, Principal::class.java)
            startActivity(home)
        }

        setupButton()
    }

    private fun setupButton(){
        var bicepIz = findViewById<EditText>(R.id.bicepIzquierdo)
        var bicepDe = findViewById<EditText>(R.id.bicepDerecho)

        var antebrazoIz = findViewById<EditText>(R.id.antebrazoIzquierdo)
        var antebrazoDe = findViewById<EditText>(R.id.antebrazoDerecho)

        var musloSupIz = findViewById<EditText>(R.id.musloSuperiorIzquierdo)
        var musloSupDe = findViewById<EditText>(R.id.musloSuperiorDerecho)

        var musloMedioIz = findViewById<EditText>(R.id.musloMedioIzquierdo)
        var musloMedioDe = findViewById<EditText>(R.id.musloMedioDerecho)

        var pantorrillaIz = findViewById<EditText>(R.id.pantorrillaIzquierda)
        var pantorrillaDe = findViewById<EditText>(R.id.pantorrillaDerecha)

        var cuello = findViewById<EditText>(R.id.cuelloEdit)
        var pecho = findViewById<EditText>(R.id.pechoEdit)
        var cintura = findViewById<EditText>(R.id.cinturaEdit)
        var cadera = findViewById<EditText>(R.id.caderaEdit)




        val guardar = findViewById<Button>(R.id.btnGuardar)
        guardar.setOnClickListener{
            //sendDataToServer()
            val enviar = Intent(this,Principal::class.java)

            val dato = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            var enviardato  = dato.edit()
            enviardato.putString("bicepIz", bicepIz.text.toString()+" cm")
            enviardato.apply()
            val dato2 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            var enviardato2  = dato2.edit()
            enviardato2.putString("bicepDe", bicepDe.text.toString()+" cm")
            enviardato2.apply()

            val dato3 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            var enviardato3  = dato3.edit()
            enviardato3.putString("antebrazoIz", antebrazoIz.text.toString()+" cm")
            enviardato3.apply()
            val dato4 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            var enviardato4  = dato4.edit()
            enviardato4.putString("antebrazoDe", antebrazoDe.text.toString()+" cm")
            enviardato4.apply()

            val dato5 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            var enviardato5  = dato5.edit()
            enviardato5.putString("musloSupIz", musloSupIz.text.toString()+" cm")
            enviardato5.apply()
            val dato6 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            var enviardato6  = dato6.edit()
            enviardato6.putString("musloSupDe", musloSupDe.text.toString()+" cm")
            enviardato6.apply()

            val dato7 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            var enviardato7  = dato7.edit()
            enviardato7.putString("musloMedioIz", musloMedioIz.text.toString()+" cm")
            enviardato7.apply()
            val dato8 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            var enviardato8  = dato8.edit()
            enviardato8.putString("musloMedioDe", musloMedioDe.text.toString()+" cm")
            enviardato8.apply()

            val dato9 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            var enviardato9  = dato9.edit()
            enviardato9.putString("pantorrillaIz", pantorrillaIz.text.toString()+" cm")
            enviardato9.apply()
            val dato10 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            var enviardato10  = dato10.edit()
            enviardato10.putString("pantorrillaDe", pantorrillaDe.text.toString()+" cm")
            enviardato10.apply()
            ////////////////////////////////////////////////////////////////////////////////
            val dato11 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            var enviardato11  = dato11.edit()
            enviardato11.putString("cuello", cuello.text.toString()+" cm")
            enviardato11.apply()

            val dato12 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            var enviardato12  = dato12.edit()
            enviardato12.putString("pecho", pecho.text.toString()+" cm")
            enviardato12.apply()

            val dato13 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            var enviardato13  = dato13.edit()
            enviardato13.putString("cintura", cintura.text.toString()+" cm")
            enviardato13.apply()

            val dato14 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            var enviardato14  = dato14.edit()
            enviardato14.putString("cadera", cadera.text.toString()+" cm")
            enviardato14.apply()

            startActivity(enviar)
        }
    }
}