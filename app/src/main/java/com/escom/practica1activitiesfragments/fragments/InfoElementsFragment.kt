package com.escom.practica1activitiesfragments.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.escom.practica1activitiesfragments.R

class InfoElementsFragment : Fragment() {

    private lateinit var tvDinamico: TextView
    private lateinit var imgView: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var btnSimular: Button
    private lateinit var tvProgreso: TextView
    private lateinit var btnVolver: Button

    private var progreso = 0
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info_elements, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        tvDinamico = view.findViewById(R.id.tvDinamico)
        imgView = view.findViewById(R.id.imgView)
        progressBar = view.findViewById(R.id.progressBar)
        btnSimular = view.findViewById(R.id.btnSimular)
        tvProgreso = view.findViewById(R.id.tvProgreso)

        // Configurar listeners
        btnSimular.setOnClickListener {
            simularCarga()
        }

        // Cambiar imagen cada 3 segundos
        cambiarImagenPeriodicamente()

        // Configurar listener del botón volver
        btnVolver.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun simularCarga() {
        progreso = 0
        progressBar.progress = 0
        tvProgreso.text = "Progreso: 0%"
        btnSimular.isEnabled = false

        val runnable = object : Runnable {
            override fun run() {
                if (progreso <= 100) {
                    progressBar.progress = progreso
                    tvProgreso.text = "Progreso: $progreso%"

                    when (progreso) {
                        0 -> tvDinamico.text = "🚀 Iniciando proceso..."
                        25 -> tvDinamico.text = "📊 Procesando datos..."
                        50 -> tvDinamico.text = "🔄 Sincronizando..."
                        75 -> tvDinamico.text = "🎯 Finalizando..."
                        100 -> {
                            tvDinamico.text = "✅ ¡Proceso completado!"
                            btnSimular.isEnabled = true
                        }
                    }

                    if (progreso < 100) {
                        progreso += 5
                        handler.postDelayed(this, 100)
                    }
                }
            }
        }
        handler.post(runnable)
    }

    private fun cambiarImagenPeriodicamente() {
        val imagenes = listOf(
            android.R.drawable.ic_dialog_email,
            android.R.drawable.ic_dialog_info,
            android.R.drawable.star_big_on,
            android.R.drawable.ic_menu_camera
        )

        var indiceImagen = 0

        val runnable = object : Runnable {
            override fun run() {
                imgView.setImageResource(imagenes[indiceImagen])
                indiceImagen = (indiceImagen + 1) % imagenes.size
                handler.postDelayed(this, 3000)
            }
        }
        handler.post(runnable)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}