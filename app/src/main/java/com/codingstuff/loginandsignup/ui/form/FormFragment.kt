package com.codingstuff.loginandsignup.ui.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.codingstuff.loginandsignup.Home
import com.codingstuff.loginandsignup.R
import com.codingstuff.loginandsignup.databinding.FragmentFormBinding
import com.codingstuff.loginandsignup.databinding.FragmentSlideshowBinding
import com.codingstuff.loginandsignup.ui.home.HomeFragment
import com.codingstuff.loginandsignup.ui.slideshow.SlideshowViewModel

class FormFragment : Fragment() {

    private var _binding: FragmentFormBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_form,container,false)
        val guardar:Button=view.findViewById(R.id.btnGuardar)
        guardar.setOnClickListener{
            val fragment = HomeFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.scrollView,fragment)?.commit()
        }
        //_binding = FragmentFormBinding.inflate(inflater, container, false)
        //val root: View = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var masculino = View.findViewById<RadioButton>(R.id.maculinoRadioButton)
        var femenino = findViewById<RadioButton>(R.id.femeninoRadioButton)
        var genero = findViewById<RadioGroup>(R.id.generoRadioGroup)

        var imperial = findViewById<RadioButton>(R.id.imperialRadioButton)
        var metrico = findViewById<RadioButton>(R.id.metricoRadioButton)
        var sistema = findViewById<RadioGroup>(R.id.sistemRadioGroup)
    }*/

}



    // This property is only valid between onCreateView and
    // onDestroyView.
    //private val binding get() = _binding!!

    //override fun onCreateView(
/*
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_form,container,false)
        val guardar : Button = view.findViewById(R.id.btnGuardar)
        guardar.setOnClickListener{
            val fragment = HomeFragment()//navegacion entre fragmentos
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_home, fragment)?.commit()
        }
        return view
    }*/
/*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/