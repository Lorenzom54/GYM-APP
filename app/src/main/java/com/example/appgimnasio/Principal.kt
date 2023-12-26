package com.example.appgimnasio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView

class Principal : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var vista: View=inflater.inflate(R.layout.fragment_princial, container, false)
        var peso = vista.findViewById<EditText>(R.id.peso)
        var altura = vista.findViewById<EditText>(R.id.altura)
        var resultado = vista.findViewById<TextView>(R.id.resultado)
        var boton = vista.findViewById<EditText>(R.id.botonIMC)

        boton.setOnClickListener{
            val peso = peso.text.toString().toFloatOrNull()
            val altura = altura.text.toString().toFloatOrNull()

            if (peso != null && altura != null && altura > 0) {

                val imc = peso / (altura * altura)

                var imcFormat = String.format("%.2f", imc)

                resultado.text = imcFormat
            } else {
                resultado.text = "Valores incorrectos(Introduzca de nuevo los valores)"
            }
        }
        return vista
    }
}