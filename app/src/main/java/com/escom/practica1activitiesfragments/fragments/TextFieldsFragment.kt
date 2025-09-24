package com.escom.practica1activitiesfragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.escom.practica1activitiesfragments.MainActivity
import com.escom.practica1activitiesfragments.R

class TextFieldsFragment : Fragment() {

    private lateinit var etNombre: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnMostrar: Button
    private lateinit var tvResultado: TextView
    private lateinit var btnVolver: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_text_fields, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        etNombre = view.findViewById(R.id.etNombre)
        etEmail = view.findViewById(R.id.etEmail)
        etPassword = view.findViewById(R.id.etPassword)
        btnMostrar = view.findViewById(R.id.btnMostrar)
        tvResultado = view.findViewById(R.id.tvResultado)
        btnVolver = view.findViewById(R.id.btnVolver)

        // Configurar listener del botón volver
        btnVolver.setOnClickListener {
            (requireActivity() as MainActivity).goBackToWelcome()
        }

        // Configurar listener del botón mostrar
        btnMostrar.setOnClickListener {
            mostrarDatos()
        }
    }

    private fun mostrarDatos() {
        val nombre = etNombre.text.toString()
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()

        if (nombre.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
            tvResultado.text = "Nombre: $nombre\nEmail: $email\nPassword: ${"*".repeat(password.length)}"
            Toast.makeText(context, "Datos capturados correctamente", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}