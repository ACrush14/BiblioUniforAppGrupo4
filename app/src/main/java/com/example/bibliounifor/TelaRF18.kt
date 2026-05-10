package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TelaRF18 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf18_amigos)

        setupRecyclerView()
        setupButtons()
        NavigationUtils.setupBottomNavigation(this)
        NavigationUtils.setupTopBar(this)
    }

    private fun setupButtons() {
        val btnAdicionarAmigo = findViewById<com.google.android.material.button.MaterialButton>(R.id.btnAdicionarAmigo)
        btnAdicionarAmigo.setOnClickListener {
            // ISSUE 1 — BOTÃO + (Abre Adicionar Amigo)
            startActivity(Intent(this, TelaRF18_2AdicionarAmigo::class.java))
        }
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rvAmigos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val mockFriends = listOf(
            Amigo(1, "Ronaldo Alves"),
            Amigo(2, "Robson Gonçalves"),
            Amigo(3, "Vitória Ferreira"),
            Amigo(4, "Marta Viana"),
            Amigo(5, "Adriano de Souza")
        )

        val adapter = AmigoAdapter(mockFriends) { amigo ->
            // Abre perfil ao clicar
            val intent = Intent(this, TelaRF18PerfilAmigo::class.java)
            intent.putExtra("AMIGO_ID", amigo.id)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}
