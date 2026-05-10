package com.example.bibliounifor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TelaRF17ListaDesejosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf17_lista_desejos)

        setupRecyclerView()
        NavigationUtils.setupBottomNavigation(this)
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rvListaDesejos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        
        // Mock data
        val mockBooks = listOf(
            com.example.bibliounifor.data.EntidadeLivro(1, "O Alienista", "Machado de Assis", coverResourceId = R.drawable.o_alienista_capa),
            com.example.bibliounifor.data.EntidadeLivro(2, "Dom Casmurro", "Machado de Assis", coverResourceId = R.drawable.osda)
        )
        
        val adapter = ListaDesejosAdapter(mockBooks)
        recyclerView.adapter = adapter
    }
}
