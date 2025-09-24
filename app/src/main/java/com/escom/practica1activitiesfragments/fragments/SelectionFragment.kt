package com.escom.practica1activitiesfragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.escom.practica1activitiesfragments.R

class SelectionFragment : Fragment() {

    private lateinit var cbOpcion1: CheckBox
    private lateinit var cbOpcion2: CheckBox
    private lateinit var cbOpcion3: CheckBox
    private lateinit var rgOpciones: RadioGroup
    private lateinit var rbOpcion1: RadioButton
    private lateinit var rbOpcion2: RadioButton
    private lateinit var rbOpcion3: RadioButton
    private lateinit var switchNotif: Switch
    private lateinit var btnMostrarSeleccion: Button
    private lateinit var tvResultados: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        cbOpcion1 = view.findViewById(R.id.cbOpcion1)
        cbOpcion2 = view.findViewById(R.id.cbOpcion2)
        cbOpcion3 = view.findViewById(R.id.cbOpcion3)
        rgOpciones = view.findViewById(R.id.rgOpciones)
        rbOpcion1 = view.findViewById(R.id.rbOpcion1)
        rbOpcion2 = view.findViewById(R.id.rbOpcion2)
        rbOpcion3 = view.findViewById(R.id.rbOpcion3)
        switchNotif = view.findViewById(R.id.switchNotif)
        btnMostrarSeleccion = view.findViewById(R.id.btnMostrarSeleccion)
        tvResultados = view.findViewById(R.id.tvResultados)

        // Configurar listeners
        btnMostrarSeleccion.setOnClickListener {
            mostrarSelecciones()
        }

        switchNotif.setOnCheckedChangeListener { _, isChecked ->
            val estado = if (isChecked) "activadas" else "desactivadas"
            Toast.makeText(context, "Notificaciones $estado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun mostrarSelecciones() {
        val checkboxes = mutableListOf<String>()

        // Verificar checkboxes
        if (cbOpcion1.isChecked) checkboxes.add("Deportes")
        if (cbOpcion2.isChecked) checkboxes.add("Música")
        if (cbOpcion3.isChecked) checkboxes.add("Tecnología")

        // Verificar radio button
        val radioSeleccionado = when (rgOpciones.checkedRadioButtonId) {
            R.id.rbOpcion1 -> "Principiante"
            R.id.rbOpcion2 -> "Intermedio"
            R.id.rbOpcion3 -> "Avanzado"
            else -> "Ninguno"
        }

        // Verificar switch
        val notificaciones = if (switchNotif.isChecked) "Activadas" else "Desactivadas"

        // Mostrar resultados
        val resultado = """
            ✅ Intereses seleccionados:
            ${if (checkboxes.isEmpty()) "Ninguno" else checkboxes.joinToString(", ")}
            
            📊 Nivel: $radioSeleccionado
            
            🔔 Notificaciones: $notificaciones
        """.trimIndent()

        tvResultados.text = resultado
    }
}