package com.escom.practica1activitiesfragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.escom.practica1activitiesfragments.R

class ButtonsFragment : Fragment() {

    private lateinit var btnNormal: Button
    private lateinit var btnSecundario: Button
    private lateinit var imgButton: ImageButton
    private lateinit var tvContador: TextView
    private lateinit var btnVolver: Button
    private var contador = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        btnNormal = view.findViewById(R.id.btnNormal)
        btnSecundario = view.findViewById(R.id.btnSecundario)
        imgButton = view.findViewById(R.id.imgButton)
        tvContador = view.findViewById(R.id.tvContador)
        btnVolver = view.findViewById(R.id.btnVolver)

        // Configurar listener del botón volver
        btnVolver.setOnClickListener {
            requireActivity().onBackPressed()
        }

        // Configurar listeners de botones
        btnNormal.setOnClickListener {
            Toast.makeText(context, "¡Botón normal presionado!", Toast.LENGTH_SHORT).show()
        }

        btnSecundario.setOnClickListener {
            Toast.makeText(context, "¡Botón secundario presionado!", Toast.LENGTH_SHORT).show()
        }

        imgButton.setOnClickListener {
            contador++
            tvContador.text = "Contador: $contador"
            Toast.makeText(context, "ImageButton presionado $contador veces", Toast.LENGTH_SHORT).show()
        }
    }
}