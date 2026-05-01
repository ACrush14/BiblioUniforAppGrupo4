package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaRF32UsuariosParaADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf32_usuariosparaadm)

        // 👇 BOTÕES PRINCIPAIS
        val btnSolicitacoes = findViewById<Button>(R.id.btnSolicitacoes)
        val btnAlugados = findViewById<Button>(R.id.btnAlugados)
        val btnAtrasos = findViewById<Button>(R.id.btnAtrasos)
        val btnExcluirConta = findViewById<Button>(R.id.btnExcluirConta)

        // Ir para RF33
        btnSolicitacoes.setOnClickListener {
            val intent = Intent(this, TelaRF33Solicitacoes::class.java)
            startActivity(intent)
        }

        // Ações simples (simulação)
        btnAlugados.setOnClickListener {
            Toast.makeText(this, "Abrir alugados (simulação)", Toast.LENGTH_SHORT).show()
        }

        btnAtrasos.setOnClickListener {
            Toast.makeText(this, "Ver atrasos (simulação)", Toast.LENGTH_SHORT).show()
        }

        btnExcluirConta.setOnClickListener {
            Toast.makeText(this, "Conta excluída (simulação)", Toast.LENGTH_SHORT).show()
        }

        // 👇 BARRA ADM
        val navUsuarios = findViewById<ImageView>(R.id.navUsuarios)
        val navSolicitacoes = findViewById<ImageView>(R.id.navSolicitacoes)
        val navLivros = findViewById<ImageView>(R.id.navLivrosADM)

        // Voltar para lista de usuários
        navUsuarios.setOnClickListener {
            val intent = Intent(this, TelaRF31GerenciamentoDeUsuarios::class.java)
            startActivity(intent)
        }

        // Ir para solicitações
        navSolicitacoes.setOnClickListener {
            val intent = Intent(this, TelaRF33Solicitacoes::class.java)
            startActivity(intent)
        }

        // Ir para livros
        navLivros.setOnClickListener {
            val intent = Intent(this, TelaRF34LivrosCRUD::class.java)
            startActivity(intent)
        }
    }
}