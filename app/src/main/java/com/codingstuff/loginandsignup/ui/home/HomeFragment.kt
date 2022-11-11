package com.codingstuff.loginandsignup.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.codingstuff.loginandsignup.Prestart
import com.codingstuff.loginandsignup.R
//import com.codingstuff.appFit.databinding.FragmentHomeBinding
import com.codingstuff.loginandsignup.databinding.FragmentHomeBinding
import com.codingstuff.loginandsignup.ui.components.dialog
import com.codingstuff.loginandsignup.ui.form.FormFragment

//import com.codingstuff.loginandsignup.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
        //return edit.root
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val edit = FragmentHomeBinding.inflate(layoutInflater)

        edit.btnEditar.setOnClickListener{
            val intent = Intent(this@HomeFragment.requireContext(),Prestart::class.java)
            startActivity(intent)
        }

        /*edit.btnEditAll.setOnClickListener{
            val intent = Intent(this.requireContext(),FormFragment::class.java)
            startActivity(intent)
        }*/

        var botonAgreg = view?.findViewById<Button>(R.id.btnMas)
        var botonResta = view?.findViewById<Button>(R.id.btnMenos)
        var cajaTexto = view?.findViewById<TextView>(R.id.resultadoTextView)
        super.onViewCreated(view, savedInstanceState)

        binding.modificarObjetivoTextView.setOnClickListener{
            val dialog = dialog(
                onSubmitClickListener = {
                    Toast.makeText(requireContext(),"Su meta es: $it Litros", Toast.LENGTH_SHORT).show()
                    var objetivo = view.findViewById<TextView>(R.id.objetivoTextView)
                    objetivo?.text="Objetivo: $it L"


                    var meta:Float =it
                    var contador = 0.00f
                    val incremento = 0.25f

                    botonAgreg?.setOnClickListener{
                        if (contador >= 0.00f) {
                            contador = contador + incremento
                            cajaTexto?.setText(contador.toString()+" L")
                        }else{
                            contador = 0.00f
                            cajaTexto?.setText(contador.toString()+" L")
                        }
                    }
                    if(contador==meta){
                        Toast.makeText(requireContext(),"Bien, has llegado a tu meta!!", Toast.LENGTH_SHORT).show()
                    }
                    botonResta?.setOnClickListener{
                        if (contador > 0.00f) {
                            contador = contador - incremento
                            cajaTexto?.setText(contador.toString()+" L")
                        }else{
                            contador = 0.00f
                            cajaTexto?.setText(contador.toString()+" L")
                        }
                    }
                    if(contador < 0.00f){
                        Toast.makeText(requireContext(),"No puedes disminuir más!!", Toast.LENGTH_SHORT).show()
                        contador = 0.00f
                        cajaTexto?.setText(contador.toString()+" L")
                    }
                }
            ).show(parentFragmentManager, "dialog")

        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}