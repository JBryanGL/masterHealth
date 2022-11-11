package com.codingstuff.loginandsignup

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.NonNull
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.codingstuff.loginandsignup.ui.components.dialog
import com.codingstuff.loginandsignup.ui.components.dialog2
import com.codingstuff.loginandsignup.ui.components.dialog3
import com.codingstuff.loginandsignup.ui.components.dialogHerramientas
import com.firebase.ui.auth.AuthUI
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.math.roundToInt

class Principal : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        val bundle = intent.extras


        /*db.collection ("users").get().addOnSuccessListener {
            var inf = users.data
            val nombre = inf.getString("nombre").toString()
            var usuario = findViewById<TextView>(R.id.nombreUsuarioTextView)
            usuario.setText(nombre)
        }*/


        val edad = findViewById<TextView>(R.id.edad)
        val sharedPreferences01 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val dato1 = sharedPreferences01.getString("edad", edad.toString())
        edad.text = dato1
        Log.d("edad", "$dato1")

        val estatura = findViewById<TextView>(R.id.estatura)
        val sharedPreferences02 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val dato2 = sharedPreferences02.getString("estatura", estatura.toString())
        estatura.text = dato2
        Log.d("estatura", "$dato2")

        val peso = findViewById<TextView>(R.id.peso)
        val sharedPreferences03 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val dato3 = sharedPreferences03.getString("peso", peso.toString())
        peso.text = dato3.toString()
        Log.d("peso", "$dato3")

        val femenino = findViewById<TextView>(R.id.genero1)
        val sharedPreferences04 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val dato5 = sharedPreferences04.getString("femenino", femenino.toString())
        femenino.text = dato5
        Log.d("femenino", "$dato5")

        val masculino = findViewById<TextView>(R.id.genero2)
        val sharedPreferences05 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val dato4 = sharedPreferences05.getString("masculino", masculino.toString())
        masculino.text = dato4
        Log.d("femenino", "$dato4")


        ///////////////////////////////////////////////////////////////

        val bicepIz = findViewById<TextView>(R.id.reciboBicepIzquierdo)
        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val tabla1 = sharedPreferences.getString("bicepIz", bicepIz.toString())
        bicepIz.text = tabla1.toString()
        Log.d("bicepIz", "$tabla1")

        val bicepDe = findViewById<TextView>(R.id.reciboBicepDerecho)
        val sharedPreferences2 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val tabla2 = sharedPreferences2.getString("bicepDe", bicepDe.toString())
        bicepDe.text = tabla2.toString()
        Log.d("bicepDe", "$tabla2")
///////////////////////////////////////////////////////////////
        val antebrazoIz = findViewById<TextView>(R.id.reciboAntebrazoIzquierdo)
        val sharedPreferences3 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val tabla3 = sharedPreferences3.getString("antebrazoIz", antebrazoIz.toString())
        antebrazoIz.text = tabla3.toString()
        Log.d("antebrazoIz", "$tabla3")

        val antebrazoDe = findViewById<TextView>(R.id.reciboAntebrazoDerecho)
        val sharedPreferences4 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val tabla4 = sharedPreferences4.getString("antebrazoDe", antebrazoDe.toString())
        antebrazoDe.text = tabla4.toString()
        Log.d("antebrazoIz", "$tabla4")
///////////////////////////////////////////////////////////////
        val musloSupIz = findViewById<TextView>(R.id.reciboMusloSupIzquierdo)
        val sharedPreferences5 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val tabla5 = sharedPreferences5.getString("musloSupIz", musloSupIz.toString())
        musloSupIz.text = tabla5.toString()
        Log.d("musloSupIz", "$tabla5")

        val musloSupDe = findViewById<TextView>(R.id.reciboMusloSupDerecho)
        val sharedPreferences6 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val tabla6 = sharedPreferences6.getString("musloSupDe", musloSupDe.toString())
        musloSupDe.text = tabla6.toString()
        Log.d("musloSupDe", "$tabla6")
///////////////////////////////////////////////////////////////
        val musloMedioIz = findViewById<TextView>(R.id.reciboMusloMeIzquierdo)
        val sharedPreferences7 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val tabla7 = sharedPreferences7.getString("musloMedioIz", musloMedioIz.toString())
        musloMedioIz.text = tabla7.toString()
        Log.d("musloMedioIz", "$tabla7")

        val musloMedioDe = findViewById<TextView>(R.id.reciboMusloMeDerecho)
        val sharedPreferences8 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val tabla8 = sharedPreferences8.getString("musloMedioDe", musloMedioDe.toString())
        musloMedioDe.text = tabla8.toString()
        Log.d("musloMedioDe", "$tabla8")
///////////////////////////////////////////////////////////////
        val pantorrillaIz = findViewById<TextView>(R.id.reciboPantorrillaIzquierda)
        val sharedPreferences9 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val tabla9 = sharedPreferences9.getString("pantorrillaIz", pantorrillaIz.toString())
        pantorrillaIz.text = tabla9.toString()
        Log.d("pantorrillaIz", "$tabla9")

        val pantorrillaDe = findViewById<TextView>(R.id.reciboPantorrillaDerecha)
        val sharedPreferences10 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val tabla10 = sharedPreferences10.getString("pantorrillaIz", pantorrillaIz.toString())
        pantorrillaDe.text = tabla10.toString()
        Log.d("pantorrillaIz", "$tabla10")
///////////////////////////////////////////////////////////////
        val cuello = findViewById<TextView>(R.id.reciboCuello)
        val sharedPreferences11 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val tabla11 = sharedPreferences11.getString("cuello", cuello.toString())
        cuello.text = tabla11.toString()
        Log.d("cuello", "$tabla11")

        val pecho = findViewById<TextView>(R.id.reciboPecho)
        val sharedPreferences12 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val tabla12 = sharedPreferences12.getString("pecho", pecho.toString())
        pecho.text = tabla12.toString()
        Log.d("pecho", "$tabla12")

        val cintura = findViewById<TextView>(R.id.reciboCintura)
        val sharedPreferences13 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val tabla13 = sharedPreferences13.getString("cintura", cintura.toString())
        cintura.text = tabla13.toString()
        Log.d("cintura", "$tabla13")

        val cadera = findViewById<TextView>(R.id.reciboCadera)
        val sharedPreferences14 = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val tabla14 = sharedPreferences14.getString("cadera", cadera.toString())
        cadera.text = tabla14.toString()
        Log.d("cadera", "$tabla14")

///////////////////////////////////////////////////////////////

        val editar = findViewById<Button> ( R.id.btnEditar )
        editar.setOnClickListener {
            var iniciar = Intent (this, Prestart :: class.java )
            startActivity ( iniciar )
        }

        val editarTabla = findViewById<Button> ( R.id.btnEditarTabla )
        editarTabla.setOnClickListener {
            var iniciar = Intent (this, PrincipalCorporal :: class.java )
            startActivity ( iniciar )
        }


///////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////

        var editarGrasa = findViewById<TextView>(R.id.btnGrasaCorporal)
        editarGrasa.setOnClickListener{
            var resultadoFinal = findViewById<TextView>(R.id.grasaTextView)
            //var grasa =  findViewById<TextView>(R.id.grasaTextView)
            val dialog2 = dialog2(
                onSubmitClickListener = {
                    Toast.makeText(this,"Grasa corporal es de: ${it.roundToInt()} %", Toast.LENGTH_SHORT).show()
                    resultadoFinal?.text=it.roundToInt().toString()+"%"
                    var composicion = findViewById<TextView>(R.id.composicionTV)
                    if(it in 2.0..5.0){
                        composicion.text="Esencial"
                    }
                    if(it in 6.0..13.0){
                        composicion.text="Atlético"
                    }
                    if(it in 14.0..17.0){
                        composicion.text="Fitness"
                    }
                    if(it in 18.0..25.0){
                        composicion.text="Aceptable"
                    }
                    if(it>=26){
                        composicion.text="Obeso"
                    }

                }

            ).show(supportFragmentManager, "dialog2")

        }
        //////////////////////////////////////////////////////////////////////////////

        var opcion = findViewById<Button>(R.id.opciones)
        opcion.setOnClickListener{
            val dialog3 = dialog3(
                onSubmitClickListener = {
                }
            ).show(supportFragmentManager, "dialog3")
        }

        var herramientas = findViewById<ImageView>(R.id.herramientasImage)
        herramientas.setOnClickListener{
            val dialogHerramientas = dialogHerramientas(
                onSubmitClickListener = {
                }
            ).show(supportFragmentManager, "dialogHerramientas")
        }

////////////////////////////////////////////////////////////////////////////////
        var modificar = findViewById<TextView>(R.id.modificarObjetivoTextView)
        modificar.setOnClickListener{
            var botonAgreg = findViewById<Button>(R.id.btnMas)
            var botonResta = findViewById<Button>(R.id.btnMenos)
            var cajaTexto =  findViewById<TextView>(R.id.resultadoTextView)
            val dialog = dialog(
                onSubmitClickListener = {
                    var contador = 0.00f
                    val incremento = 0.25f

                    Toast.makeText(this,"Su meta es: $it Litros", Toast.LENGTH_SHORT).show()
                    var objetivo = findViewById<TextView>(R.id.objetivoTextView)
                    objetivo.text = "Objetivo: "+it+" L"


                    /*if(contador == objetivo){
                        Toast.makeText(this,"Bien, has llegado a tu meta!!", Toast.LENGTH_SHORT).show()
                    }*/
                    botonAgreg?.setOnClickListener{
                        if (contador >= 0.00f) {
                            contador += incremento
                            cajaTexto?.setText(contador.toString()+" L")
                        }else{
                            contador = 0.00f
                            cajaTexto?.setText(contador.toString()+" L")
                        }
                    }
                    botonResta?.setOnClickListener{
                        if (contador > 0.00f) {
                            contador -= incremento
                            cajaTexto?.setText(contador.toString()+" L")
                        }else{
                            contador = 0.00f
                            cajaTexto?.setText(contador.toString()+" L")
                        }
                    }
                    if(contador < 0.0){
                        Toast.makeText(this,"No puedes disminuir más!!", Toast.LENGTH_SHORT).show()
                        contador = 0.00f
                        cajaTexto?.setText(contador.toString()+" L")
                    }
                }
            ).show(supportFragmentManager, "dialog")

        }
        ///////////////////////////////////////////////////////////////////////
        var botonPerfil = findViewById<Button>(R.id.btnEditPerfil)
        botonPerfil.setOnClickListener{requestPermission()}

        var botonPortada = findViewById<Button>(R.id.btnEditPortada)
        botonPortada.setOnClickListener{requestPermission2()}
/////////////////////////////////////////////////////////////////
    }


    private fun requestPermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            when {
                ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED -> {
                    pickPhotoFromGallery()
                }
                else -> requestPermissionLauncher.launch( android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }

        }else{
            pickPhotoFromGallery()
        }
    }
    private fun requestPermission2() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            when {
                ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED -> {
                    pickPhotoFromGallery2()
                }
                else -> requestPermissionLauncher2.launch( android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }

        }else{
            pickPhotoFromGallery2()
        }
    }
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){isGranted->
        if(isGranted){
            pickPhotoFromGallery()
        }else{
            Toast.makeText(this,"Necesitas Activar los Permisos", Toast.LENGTH_SHORT).show()
        }

    }
    private val requestPermissionLauncher2 = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){isGranted->
        if(isGranted){
            pickPhotoFromGallery2()
        }else{
            Toast.makeText(this,"Necesitas Activar los Permisos", Toast.LENGTH_SHORT).show()
        }

    }

    private val startForActivityGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){result ->
        if (result.resultCode == Activity.RESULT_OK){
            val data = result.data?.data

            var fotoPerfil = findViewById<ImageView>(R.id.perfilImageView)
            fotoPerfil.setImageURI(data)

        }
    }

    private val startForActivityGallery2 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){result ->
        if (result.resultCode == Activity.RESULT_OK){
            val data = result.data?.data

            var fotoPortada = findViewById<ImageView>(R.id.portadaImageView)
            fotoPortada.setImageURI(data)

        }
    }

    private fun pickPhotoFromGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startForActivityGallery.launch(intent)
    }
    private fun pickPhotoFromGallery2() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startForActivityGallery2.launch(intent)
    }



}