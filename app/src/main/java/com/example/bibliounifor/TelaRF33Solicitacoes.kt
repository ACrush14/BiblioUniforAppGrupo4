package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaRF33Solicitacoes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf33_solicitacoes)

        // 👇 BOTÃO FECHAR (X)
        val btnFechar = findViewById<TextView>(R.id.btnFechar)

        btnFechar.setOnClickListener {
            finish()
        }

        // 👇 ITENS DE SOLICITAÇÃO
        val item1 = findViewById<LinearLayout>(R.id.itemSolicitacao1)
        val item2 = findViewById<LinearLayout>(R.id.itemSolicitacao2)

        item1.setOnClickListener {
            Toast.makeText(this, "Solicitação 1 selecionada", Toast.LENGTH_SHORT).show()
        }

        item2.setOnClickListener {
            Toast.makeText(this, "Solicitação 2 selecionada", Toast.LENGTH_SHORT).show()
        }

        // 👇 BARRA ADM
        val navUsuarios = findViewById<ImageView>(R.id.navUsuarios)
        val navSolicitacoes = findViewById<ImageView>(R.id.navSolicitacoes)
        val navLivros = findViewById<ImageView>(R.id.navLivrosADM)

        // Ir para RF31
        navUsuarios.setOnClickListener {
            val intent = Intent(this, TelaRF31GerenciamentoDeUsuarios::class.java)
            startActivity(intent)
        }

        // Já está na tela de solicitações
        navSolicitacoes.setOnClickListener {
            // não faz nada
        }

        // Ir para RF34
        navLivros.setOnClickListener {
            val intent = Intent(this, TelaRF34LivrosCRUD::class.java)
            startActivity(intent)
        }
    }
}