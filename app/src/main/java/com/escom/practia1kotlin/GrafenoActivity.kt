package com.escom.practia1kotlin

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class GrafenoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grafeno)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        val imgGrafeno = findViewById<ImageView>(R.id.imgGrafeno)

        // Animación de entrada para la imagen
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_up)

        imgGrafeno.startAnimation(fadeInAnimation)

        // Botón de regreso
        btnBack.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}