package com.escom.practia1kotlin

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MaterialDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_detail)

        val materialType = intent.getStringExtra(MainActivity.EXTRA_MATERIAL_TYPE)

        // Referencias a las vistas
        val mainLayout = findViewById<ConstraintLayout>(R.id.mainLayout)
        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        val imgMaterial = findViewById<ImageView>(R.id.imgMaterial)
        val txtTitulo = findViewById<TextView>(R.id.txtTitulo)
        val txtDescripcion = findViewById<TextView>(R.id.txtDescripcion)
        val txtCaracteristicas = findViewById<TextView>(R.id.txtCaracteristicas)

        // Configurar contenido según el material
        when (materialType) {
            MainActivity.MATERIAL_GRAFENO -> {
                setupGrafeno(mainLayout, imgMaterial, txtTitulo, txtDescripcion, txtCaracteristicas)
            }
            MainActivity.MATERIAL_DIAMANTE -> {
                setupDiamante(mainLayout, imgMaterial, txtTitulo, txtDescripcion, txtCaracteristicas)
            }
            MainActivity.MATERIAL_CARBURO -> {
                setupCarburo(mainLayout, imgMaterial, txtTitulo, txtDescripcion, txtCaracteristicas)
            }
        }

        // Animación de entrada para la imagen
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        imgMaterial.startAnimation(fadeInAnimation)

        // Botón de regreso
        btnBack.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }

    private fun setupGrafeno(
        layout: ConstraintLayout,
        image: ImageView,
        titulo: TextView,
        descripcion: TextView,
        caracteristicas: TextView
    ) {
        layout.setBackgroundColor(getColor(android.R.color.holo_blue_bright))
        image.setImageResource(R.drawable.ic_grafeno) // Cambia por tu imagen
        titulo.text = "🔬 GRAFENO"
        titulo.setTextColor(getColor(android.R.color.holo_blue_dark))

        descripcion.text = getString(R.string.grafeno_descripcion)
        caracteristicas.text = getString(R.string.grafeno_caracteristicas)
    }

    private fun setupDiamante(
        layout: ConstraintLayout,
        image: ImageView,
        titulo: TextView,
        descripcion: TextView,
        caracteristicas: TextView
    ) {
        layout.setBackgroundColor(getColor(android.R.color.holo_red_light))
        image.setImageResource(R.drawable.ic_diamante) // Cambia por tu imagen
        titulo.text = "💎 DIAMANTE"
        titulo.setTextColor(getColor(android.R.color.holo_red_dark))

        descripcion.text = getString(R.string.diamante_descripcion)
        caracteristicas.text = getString(R.string.diamante_caracteristicas)
    }

    private fun setupCarburo(
        layout: ConstraintLayout,
        image: ImageView,
        titulo: TextView,
        descripcion: TextView,
        caracteristicas: TextView
    ) {
        layout.setBackgroundColor(getColor(android.R.color.holo_purple))
        image.setImageResource(R.drawable.ic_carburo) // Cambia por tu imagen
        titulo.text = "⚒️ CARBURO DE TUNGSTENO"
        titulo.setTextColor(getColor(android.R.color.holo_purple))

        descripcion.text = getString(R.string.carburo_descripcion)
        caracteristicas.text = getString(R.string.carburo_caracteristicas)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}