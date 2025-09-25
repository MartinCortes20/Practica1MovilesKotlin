package com.escom.practica1activitiesfragments

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ButtonsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        title = "Activity de Botones"

        val tvMensaje = findViewById<TextView>(R.id.tvMensaje)
        tvMensaje.text = "Holaaa\nEsta es otra Activity\n(Buttons Detail)"

        val animation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        tvMensaje.startAnimation(animation)
    }
}