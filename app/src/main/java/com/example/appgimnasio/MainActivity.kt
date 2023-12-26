package com.example.appgimnasio


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.ImageButton


class MainActivity : AppCompatActivity() {


    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainer, Principal())
            fragmentTransaction.commit()
        }

        val bEjercicios = findViewById<ImageButton>(R.id.boton2)
        val bAnaliticas = findViewById<ImageButton>(R.id.boton3)

        bEjercicios.setOnClickListener { cargarFragment(1) }
        bAnaliticas.setOnClickListener { cargarFragment(2) }
    }


    fun cargarFragment(numF: Int) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        var fragment: Fragment = Fragment()
        when (numF) {
            1 -> fragment = Ejercicios()
            2 -> fragment = Analisis()
        }
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}