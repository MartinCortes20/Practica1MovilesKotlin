package com.escom.practica1activitiesfragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.escom.practica1activitiesfragments.MainActivity
import com.escom.practica1activitiesfragments.R
import com.escom.practica1activitiesfragments.adapters.SampleAdapter
import android.content.Intent
import com.escom.practica1activitiesfragments.ListsDetailActivity


class ListsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SampleAdapter
    private lateinit var btnVolver: Button
    private lateinit var btnAbrirActivity: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lists, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        recyclerView = view.findViewById(R.id.recyclerView)
        btnVolver = view.findViewById(R.id.btnVolver)

        btnAbrirActivity = view.findViewById(R.id.btnAbrirActivity)


        // Configurar listener del botón volver
        btnVolver.setOnClickListener {
            (requireActivity() as MainActivity).goBackToWelcome()
        }

        btnAbrirActivity.setOnClickListener {
            val intent = Intent(requireContext(), ListsDetailActivity::class.java)
            startActivity(intent)
        }

        // Configurar RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Datos de ejemplo
        val items = listOf(
            "📱 Smartphone Samsung Galaxy",
            "💻 Laptop Dell Inspiron",
            "🎧 Auriculares Sony",
            "📺 Smart TV LG 55\"",
            "⌚ Apple Watch Series 8",
            "🖥️ Monitor Gaming ASUS",
            "📷 Cámara Canon EOS",
            "🎮 PlayStation 5",
            "💾 SSD Kingston 1TB",
            "🖨️ Impresora HP LaserJet",
            "📖 Tablet iPad Air",
            "🔊 Altavoz Bluetooth JBL"
        )

        // Configurar adapter
        adapter = SampleAdapter(items) { item, position ->
            Toast.makeText(context, "Seleccionaste: $item (Posición: $position)", Toast.LENGTH_SHORT).show()
        }

        recyclerView.adapter = adapter
    }
}