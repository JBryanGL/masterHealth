package com.codingstuff.loginandsignup.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.codingstuff.loginandsignup.R
import com.codingstuff.loginandsignup.databinding.FragmentGalleryBinding


class GalleryFragment : Fragment() {


    private var _binding: FragmentGalleryBinding? = null




    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)


        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GalleryFragment.inflate(layoutInflater)
        setContentView(binding.root)

        var  Contador = 0.0
        val Incremento = 0.255

        var botonAgreg = findViewById<Button>(R.id.botonAgregarAgua)
        var botonResta = findViewById<Button>(R.id.botonQuitarAgua)
        var cajaTexto = findViewById<TextView>(R.id.textViewResultado)

        botonAgreg.setOnClickListener{
            if (Contador >= 0) {
                Contador = Contador + Incremento
                cajaTexto.setText(Contador.toString())
            }else{
                Contador = 0.0
                cajaTexto.setText(Contador.toString())
            }

        }
        botonResta.setOnClickListener{
            if (Contador >= 0) {

                Contador = Contador - Incremento
                cajaTexto.setText(Contador.toString())
            }else{
                Contador = 0.0
                cajaTexto.setText(Contador.toString())
            }

        }


        binding.buttonPerfil.setOnClickListener{requestPermission()}
        binding2.buttonPortada.setOnClickListener{requestPermission()}

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
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){isGranted->
        if(isGranted){
            pickPhotoFromGallery()

        }else{
            Toast.makeText(this,"Necesitas Activar los Permisos", Toast.LENGTH_SHORT).show()
        }

    }

    private val startForActivityGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){result ->
        if (result.resultCode == Activity.RESULT_OK){
            val data = result.data?.data

            binding.imageViewPerfil.setImageURI(data)
            binding2.imageViewPortada.setImageURI(data)

        }
    }

    private fun pickPhotoFromGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startForActivityGallery.launch(intent)
    }
}*/