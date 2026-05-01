package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class TelaRF31GerenciamentoDeUsuarios : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf31_gerenciamentousuarios)

        // 👇 USUÁRIOS
        val usuario1 = findViewById<LinearLayout>(R.id.itemUsuario1)
        val usuario2 = findViewById<LinearLayout>(R.id.itemUsuario2)

        usuario1.setOnClickListener {
            val intent = Intent(this, TelaRF32UsuariosParaADM::class.java)
            startActivity(intent)
        }

        usuario2.setOnClickListener {
            val intent = Intent(this, TelaRF32UsuariosParaADM::class.java)
            startActivity(intent)
        }

        // 👇 BARRA DE TAREFAS ADM
        val navUsuarios = findViewById<ImageView>(R.id.navUsuarios)
        val navSolicitacoes = findViewById<ImageView>(R.id.navSolicitacoes)
        val navLivros = findViewById<ImageView>(R.id.navLivrosADM)

        // Já está nessa tela
        navUsuarios.setOnClickListener { }

        // Ir para RF33
        navSolicitacoes.setOnClickListener {
            val intent = Intent(this, TelaRF33Solicitacoes::class.java)
            startActivity(intent)
        }

        // Ir para RF34
        navLivros.setOnClickListener {
            val intent = Intent(this, TelaRF34LivrosCRUD::class.java)
            startActivity(intent)
        }
    }
}