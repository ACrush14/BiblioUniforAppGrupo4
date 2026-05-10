package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TelaRF18BuscaAmigos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf18_busca_amigos)

        val recyclerView = findViewById<RecyclerView>(R.id.rvBuscaAmigos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val mockSearchResults = listOf(
            Amigo(10, "Carlos Alberto", "carlos@email.com", "@carlos_alb", "Amante de livros de história."),
            Amigo(11, "Mariana Silva", "mariana@email.com", "@mari_silva", "Sempre lendo algo novo.")
        )

        val adapter = AmigoAdapter(mockSearchResults, isBusca = true) { amigo ->
            val intent = Intent(this@TelaRF18BuscaAmigos, TelaRF18PerfilAmigo::class.java)
            intent.putExtra("AMIGO_ID", amigo.id)
            intent.putExtra("AMIGO_NOME", amigo.nome)
            intent.putExtra("AMIGO_USER", amigo.usuario)
            intent.putExtra("AMIGO_BIO", amigo.bio)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}
