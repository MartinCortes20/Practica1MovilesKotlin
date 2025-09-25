package com.escom.practica1activitiesfragments

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TextFieldsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        title = "Activity de TextFields"

        val tvMensaje = findViewById<TextView>(R.id.tvMensaje)

        // Configurar el mensaje
        tvMensaje.text = "Holaaa\nEsta es otra Activity\n(TextFields Detail)"

        // Aplicar animación
        val animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        tvMensaje.startAnimation(animation)
    }
}