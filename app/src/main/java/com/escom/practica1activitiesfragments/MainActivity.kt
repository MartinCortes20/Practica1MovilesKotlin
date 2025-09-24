package com.escom.practica1activitiesfragments

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.escom.practica1activitiesfragments.fragments.*
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {

    private lateinit var welcomeScreen: View
    private lateinit var fragmentContainer: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar vistas
        welcomeScreen = findViewById(R.id.welcomeScreen)
        fragmentContainer = findViewById(R.id.fragmentContainer)

        // Configurar botón atrás
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (fragmentContainer.visibility == View.VISIBLE) {
                    // Volver a pantalla de bienvenida
                    fragmentContainer.visibility = View.GONE
                    welcomeScreen.visibility = View.VISIBLE
                } else {
                    // Salir de la app
                    finish()
                }
            }
        })

        // Inicializar cards
        val cardTextFields = findViewById<MaterialCardView>(R.id.cardTextFields)
        val cardButtons = findViewById<MaterialCardView>(R.id.cardButtons)
        val cardSelection = findViewById<MaterialCardView>(R.id.cardSelection)
        val cardLists = findViewById<MaterialCardView>(R.id.cardLists)
        val cardInfoElements = findViewById<MaterialCardView>(R.id.cardInfoElements)

        // Configurar listeners de cards
        cardTextFields.setOnClickListener {
            showFragment(TextFieldsFragment())
        }

        cardButtons.setOnClickListener {
            showFragment(ButtonsFragment())
        }

        cardSelection.setOnClickListener {
            showFragment(SelectionFragment())
        }

        cardLists.setOnClickListener {
            showFragment(ListsFragment())
        }

        cardInfoElements.setOnClickListener {
            showFragment(InfoElementsFragment())
        }
    }

    private fun showFragment(fragment: Fragment) {
        // Ocultar pantalla de bienvenida y mostrar fragment
        welcomeScreen.visibility = View.GONE
        fragmentContainer.visibility = View.VISIBLE

        // Cargar el fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    fun goBackToWelcome() {
        fragmentContainer.visibility = View.GONE
        welcomeScreen.visibility = View.VISIBLE
    }
}