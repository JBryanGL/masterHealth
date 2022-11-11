package com.codingstuff.loginandsignup

import android.media.RingtoneManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.mikhaellopez.circularprogressbar.CircularProgressBar

class Frecuencia : AppCompatActivity() {

    private var tvCuentaAtras: TextView?=null
    var tiempoDefinido:Long = 16

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frecuencia)
        tvCuentaAtras=findViewById(R.id.tvCuentaAtras)

        var edad = findViewById<EditText>(R.id.edadFrecuencia)
        var pulsaciones = findViewById<EditText>(R.id.pulsacionesFrecuencia)
        var calcular = findViewById<Button>(R.id.calcularFrecuencia)
        var text1 = findViewById<TextView>(R.id.frecuenciaPersonalTV)
        var text2 = findViewById<TextView>(R.id.frecuenciaMaximaTV)

        calcular.setOnClickListener{
            text1.setText("Frecuencia cardíaca: " + (pulsaciones.text.toString().toInt() * 4) + " (ppm)")
            text2.setText("Frecuencia cardíaca máxima: "+(200-edad.text.toString().toInt()) + " (ppm)")
        }
    }
    fun play(view: View){

        var tiempoMilisegundos=tiempoDefinido*1000
        object : CountDownTimer(tiempoMilisegundos,1000){
            override fun onFinish() {
                val notificacion= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val r=RingtoneManager.getRingtone(this@Frecuencia, notificacion)
                r.play()
                this.cancel()
            }
            override fun onTick(millisUntilFinished: Long) {
                var progress_circular: CircularProgressBar = findViewById(R.id.progress_circular)
                val tiempoSegundos=(millisUntilFinished/1000).toInt()
                progress_circular.apply {
                    setProgressWithAnimation(tiempoSegundos.toFloat())
                }
                tvCuentaAtras?.text=tiempoSegundos.toString().padStart(2,'0')
            }
        }.start()
    }
}