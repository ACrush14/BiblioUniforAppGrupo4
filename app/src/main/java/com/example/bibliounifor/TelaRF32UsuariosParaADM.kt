package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaRF32UsuariosParaADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔹 Nome do XML CORRETO
        setContentView(R.layout.telarf32_usuariosparaadm)

        // 🔹 Botões (IDs do seu XML)
        val btnSolicitacoes = findViewById<Button>(R.id.btnSolicitacoes)
        val btnAlugados = findViewById<Button>(R.id.btnAlugados)
        val btnAtrasos = findViewById<Button>(R.id.btnAtrasos)
        val btnExcluirConta = findViewById<Button>(R.id.btnExcluirConta)

        // 🔹 Abrir RF33 (Solicitações)
        btnSolicitacoes.setOnClickListener {
            val intent = Intent(this, TelaRF33Solicitacoes::class.java)
            startActivity(intent)
        }

        // 🔹 Ações simuladas (pra não deixar botão morto)
        btnAlugados.setOnClickListener {
            Toast.makeText(this, "Abrir livros alugados", Toast.LENGTH_SHORT).show()
        }

        btnAtrasos.setOnClickListener {
            Toast.makeText(this, "Ver atrasos de aluguel", Toast.LENGTH_SHORT).show()
        }

        btnExcluirConta.setOnClickListener {
            Toast.makeText(this, "Conta excluída (simulação)", Toast.LENGTH_SHORT).show()
        }
    }
}