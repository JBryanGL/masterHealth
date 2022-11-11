package com.codingstuff.loginandsignup

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.codingstuff.loginandsignup.ui.components.dialogHerramientas
import com.codingstuff.loginandsignup.ui.components.helpPedometro
import com.mikhaellopez.circularprogressbar.CircularProgressBar

class podome : AppCompatActivity() , SensorEventListener {

    private var sensorManager: SensorManager? = null
    private var running = false
    private var totalSteps = 0f
    private var previousTotalSteps = 0f

    val chanelID="chat"
    val chanelName = "chat"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_podome)
        loadData()
        resetSteps()
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        var regresar = findViewById<Button>(R.id.atras)
        regresar.setOnClickListener{
            startActivity(Intent(this,Principal::class.java))
        }

        var ayuda = findViewById<Button>(R.id.ayudaButton)
        ayuda.setOnClickListener{
            val helpPedometro = helpPedometro(
                onSubmitClickListener = {
                }
            ).show(supportFragmentManager, "helpPedometro")
        }
    }

    override fun onResume() {
        super.onResume()
        running = true

        val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (stepSensor == null) {
            Toast.makeText(this, "Sensor no detectado", Toast.LENGTH_SHORT).show()
        } else {
            sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        var tv_stepsTaken = findViewById<TextView>(R.id.tv_stepsTaken)
        if (running) {
            var progress_circular:CircularProgressBar = findViewById(R.id.progress_circular)
            totalSteps = event!!.values[0]
            val currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()
            tv_stepsTaken.text = ("$currentSteps")
            progress_circular.apply {
                setProgressWithAnimation(currentSteps.toFloat())
            }
            //////////////////////////////////////////////////////////////////////
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val importancia = NotificationManager.IMPORTANCE_HIGH
                val channel = NotificationChannel(chanelID, chanelName,importancia)

                val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                manager.createNotificationChannel(channel)
                ///////////////////////////////////////////////////////////////////////////
                if(currentSteps in 5000..5010){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡Has llegado a la mitad de la meta de pasos diarios!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }
                if(currentSteps in 10000..10010){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡Has llegado a la meta en pasos diarios!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }
                /////////////////////////////////////////////////////////////////////////////////////////////
                if(currentSteps in 625..630){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡No te olvides de tomar agua!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }
                if(currentSteps in 1250..1255){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡No te olvides de tomar agua!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }
                if(currentSteps in 1875..1880){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡No te olvides de tomar agua!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }
                if(currentSteps in 2500..2505){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡No te olvides de tomar agua!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }
                if(currentSteps in 3125..3130){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡No te olvides de tomar agua!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }
                if(currentSteps in 3750..3755){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡No te olvides de tomar agua!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }
                if(currentSteps in 4375..4380){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡No te olvides de tomar agua!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }
                if(currentSteps in 5000..5005){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡No te olvides de tomar agua!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }
                if(currentSteps in 5625..5630){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡No te olvides de tomar agua!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }
                if(currentSteps in 6250..6255){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡No te olvides de tomar agua!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }
                if(currentSteps in 6875..6880){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡No te olvides de tomar agua!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }
                if(currentSteps in 7500..7505){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡No te olvides de tomar agua!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }
                if(currentSteps in 8125..8130){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡No te olvides de tomar agua!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }
                if(currentSteps in 8750..8755){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡No te olvides de tomar agua!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }
                if(currentSteps in 9375..9380){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡No te olvides de tomar agua!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }
                if(currentSteps in 10000..10005){
                    val notification = NotificationCompat.Builder(this, chanelID).also{ noti ->
                        noti.setContentTitle("Master Health")
                        noti.setContentText("¡No te olvides de tomar agua!")
                        noti.setSmallIcon(R.drawable.logo1)
                    }.build()
                    val notificationManageer = NotificationManagerCompat.from(applicationContext)
                    notificationManageer.notify(1,notification)
                }

            }
        }
    }

    fun resetSteps() {
        var tv_stepsTaken = findViewById<TextView>(R.id.tv_stepsTaken)
        tv_stepsTaken.setOnClickListener {

            Toast.makeText(this, "Da un toque largo para reiniciar pasos", Toast.LENGTH_SHORT).show()
        }
        tv_stepsTaken.setOnLongClickListener {
            previousTotalSteps = totalSteps

            tv_stepsTaken.text = 0.toString()

            saveData()
            true
        }
    }
    private fun saveData() {

        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putFloat("key1", previousTotalSteps)
        editor.apply()
    }
    private fun loadData() {

        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val savedNumber = sharedPreferences.getFloat("key1", 0f)

        Log.d("podome", "$savedNumber")
        previousTotalSteps = savedNumber
    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

}