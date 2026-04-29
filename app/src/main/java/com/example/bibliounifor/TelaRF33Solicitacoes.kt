package com.example.bibliouniforappgrupo4_v02

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaRF33Solicitacoes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔹 Nome do XML CORRETO
        setContentView(R.layout.telarf33_solicitacoes)

        // 🔹 Botão fechar (X)
        val btnFechar = findViewById<TextView>(R.id.btnFechar)

        // 🔹 Itens da lista
        val item1 = findViewById<LinearLayout>(R.id.itemSolicitacao1)
        val item2 = findViewById<LinearLayout>(R.id.itemSolicitacao2)

        // 🔹 Fechar tela (volta pra RF32)
        btnFechar.setOnClickListener {
            finish()
        }

        // 🔹 Clique item 1
        item1.setOnClickListener {
            Toast.makeText(this, "Solicitação 1 selecionada", Toast.LENGTH_SHORT).show()
        }

        // 🔹 Clique item 2
        item2.setOnClickListener {
            Toast.makeText(this, "Solicitação 2 selecionada", Toast.LENGTH_SHORT).show()
        }
    }
}