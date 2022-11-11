package com.codingstuff.loginandsignup

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*


class Prestart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prestart)

        var imperial = findViewById<RadioButton>(R.id.imperialRadioButton)
        var metrico = findViewById<RadioButton>(R.id.metricoRadioButton)
        //var sistema = findViewById<RadioGroup>(R.id.sistemRadioGroup)
        var cajaTexto = findViewById<TextView>(R.id.cajaTexto)

            imperial.setOnCheckedChangeListener { buttonView, isChecked ->
                cajaTexto.setText("Se usarán pulgadas (in), pies (ft) y libras (lb)  como unidades de medida.")
            }

            metrico.setOnCheckedChangeListener { buttonView, isChecked ->
                cajaTexto.setText("Se usarán centímetros (cm), metros (m) y kilogramos (kg) como unidades de medida.")
                cajaTexto.clearComposingText()
            }


        setupButton()
        val home = findViewById<Button>(R.id.atras)
        home.setOnClickListener{
            var home = Intent(this, Principal::class.java)
            startActivity(home)
        }
    }
    private fun setupButton(){
         var edad = findViewById<EditText>(R.id.edadEditText)
         var estatura = findViewById<EditText>(R.id.estaturaEditText)
         var peso = findViewById<EditText>(R.id.pesoEditText)
         var masculino = findViewById<RadioButton>(R.id.maculinoRadioButton)
         var femenino = findViewById<RadioButton>(R.id.femeninoRadioButton)
         //var genero = findViewById<RadioGroup>(R.id.generoRadioGroup)

        val guardar = findViewById<Button>(R.id.btnGuardar)
        guardar.setOnClickListener{
            sendDataToServer()
            val enviar = Intent(this,Principal::class.java)

            val dato = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            var enviardato  = dato.edit()
            enviardato.putString("edad", edad.text.toString()+" años")
            enviardato.apply()

            val dato1 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            var enviardato1  = dato1.edit()
            enviardato1.putString("estatura", estatura.text.toString()+" cm")
            enviardato1.apply()

            val dato2 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            var enviardato2  = dato2.edit()
            enviardato2.putString("peso", peso.text.toString()+" Kg")
            enviardato2.apply()


            //enviar.putExtra("estatura", estatura.text.toString()+" cm")
            //enviar.putExtra("peso", peso.text.toString()+" Kg")
            if(femenino.isChecked()){
                val dato3 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
                var enviardato3  = dato3.edit()
                enviardato3.putString("femenino", "F")
                enviardato3.apply()

                //enviar.putExtra("femenino", "F")
            }else if(masculino.isChecked()){
                val dato4 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
                var enviardato4  = dato4.edit()
                enviardato4.putString("masculino", "M")
                enviardato4.apply()

                //enviar.putExtra("masculino", "M")
            }
            startActivity(enviar)
        }
    }

    private fun sendDataToServer() {
        var edad = findViewById<EditText>(R.id.edadEditText)
        var estatura = findViewById<EditText>(R.id.estaturaEditText)
        var peso = findViewById<EditText>(R.id.pesoEditText)
        val dataStr = "Edad: ${edad.text.toString()}," +
                "estatura: ${estatura.text.toString()},"+
                "peso: ${peso.text.toString()},"
        Log.i("Data sent", dataStr)
    }

}