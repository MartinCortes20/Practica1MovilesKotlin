package com.escom.practia1kotlin

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    // Agrega estas constantes como companion object
    companion object {
        const val EXTRA_MATERIAL_TYPE = "material_type"
        const val MATERIAL_GRAFENO = "grafeno"
        const val MATERIAL_DIAMANTE = "diamante"
        const val MATERIAL_CARBURO = "carburo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a las tarjetas
        val cardGrafeno = findViewById<CardView>(R.id.cardGrafeno)
        val cardDiamante = findViewById<CardView>(R.id.cardDiamante)
        val cardCarburo = findViewById<CardView>(R.id.cardCarburo)

        // Animaciones de entrada
        val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_up)

        // Aplicar animaciones con delay
        cardGrafeno.startAnimation(slideInAnimation)

        cardDiamante.postDelayed({
            cardDiamante.startAnimation(slideInAnimation)
        }, 150)

        cardCarburo.postDelayed({
            cardCarburo.startAnimation(slideInAnimation)
        }, 300)

        // Click listeners modificados para usar MaterialDetailActivity
        cardGrafeno.setOnClickListener {
            animateCardClick(cardGrafeno) {
                val intent = Intent(this, MaterialDetailActivity::class.java)
                intent.putExtra(EXTRA_MATERIAL_TYPE, MATERIAL_GRAFENO)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }

        cardDiamante.setOnClickListener {
            animateCardClick(cardDiamante) {
                val intent = Intent(this, MaterialDetailActivity::class.java)
                intent.putExtra(EXTRA_MATERIAL_TYPE, MATERIAL_DIAMANTE)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }

        cardCarburo.setOnClickListener {
            animateCardClick(cardCarburo) {
                val intent = Intent(this, MaterialDetailActivity::class.java)
                intent.putExtra(EXTRA_MATERIAL_TYPE, MATERIAL_CARBURO)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }
    }

    private fun animateCardClick(card: CardView, action: () -> Unit) {
        val scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down)
        card.startAnimation(scaleDown)

        // Ejecutar la acción después de la animación
        card.postDelayed({
            action()
        }, 150)
    }
}