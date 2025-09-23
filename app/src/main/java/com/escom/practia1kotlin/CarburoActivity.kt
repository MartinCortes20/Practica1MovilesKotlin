package com.escom.practia1kotlin

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class CarburoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carburo)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        val imgCarburo = findViewById<ImageView>(R.id.imgCarburo)

        // Animación de entrada para la imagen
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        imgCarburo.startAnimation(fadeInAnimation)

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