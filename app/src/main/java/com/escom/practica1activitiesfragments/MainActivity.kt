package com.escom.practica1activitiesfragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.escom.practica1activitiesfragments.fragments.*
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var welcomeScreen: View
    private lateinit var fragmentContainer: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
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
            val cardTextFields = findViewById<CardView>(R.id.cardTextFields)
            val cardButtons = findViewById<CardView>(R.id.cardButtons)
            val cardSelection = findViewById<CardView>(R.id.cardSelection)
            val cardLists = findViewById<CardView>(R.id.cardLists)
            val cardInfoElements = findViewById<CardView>(R.id.cardInfoElements)

            // Configurar listeners de cards
            cardTextFields.setOnClickListener {
                Toast.makeText(this, "Click detectado en TextFields", Toast.LENGTH_SHORT).show()
                try {
                    showFragment(TextFieldsFragment())
                } catch (e: Exception) {
                    Toast.makeText(this, "Error en TextFields: ${e.message}", Toast.LENGTH_LONG).show()
                    e.printStackTrace()
                }
            }

            cardButtons.setOnClickListener {
                Toast.makeText(this, "Click detectado en Buttons", Toast.LENGTH_SHORT).show()
                try {
                    showFragment(ButtonsFragment())
                } catch (e: Exception) {
                    Toast.makeText(this, "Error en Buttons: ${e.message}", Toast.LENGTH_LONG).show()
                    e.printStackTrace()
                }
            }

            cardSelection.setOnClickListener {
                Toast.makeText(this, "Click detectado en Selection", Toast.LENGTH_SHORT).show()
                try {
                    showFragment(SelectionFragment())
                } catch (e: Exception) {
                    Toast.makeText(this, "Error en Selection: ${e.message}", Toast.LENGTH_LONG).show()
                    e.printStackTrace()
                }
            }

            cardLists.setOnClickListener {
                Toast.makeText(this, "Click detectado en Lists", Toast.LENGTH_SHORT).show()
                try {
                    showFragment(ListsFragment())
                } catch (e: Exception) {
                    Toast.makeText(this, "Error en Lists: ${e.message}", Toast.LENGTH_LONG).show()
                    e.printStackTrace()
                }
            }

            cardInfoElements.setOnClickListener {
                Toast.makeText(this, "Click detectado en InfoElements", Toast.LENGTH_SHORT).show()
                try {
                    showFragment(InfoElementsFragment())
                } catch (e: Exception) {
                    Toast.makeText(this, "Error en InfoElements: ${e.message}", Toast.LENGTH_LONG).show()
                    e.printStackTrace()
                }
            }

            Toast.makeText(this, "App cargada correctamente", Toast.LENGTH_SHORT).show()

        } catch (e: Exception) {
            Toast.makeText(this, "Error general: ${e.message}", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    private fun showFragment(fragment: Fragment) {
        Toast.makeText(this, "Mostrando fragment...", Toast.LENGTH_SHORT).show()

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