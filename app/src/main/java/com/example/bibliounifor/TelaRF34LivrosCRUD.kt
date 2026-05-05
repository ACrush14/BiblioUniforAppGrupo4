package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaRF34LivrosCRUD : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf34_livroscrud)

        // 🔹 Botão Criar Mídia (ID btnCriarMidia deve bater com o XML)
        val btnCriarMidia = findViewById<Button>(R.id.btnCriarMidia)
        
        btnCriarMidia.setOnClickListener {
            Toast.makeText(this, "Abrindo Cadastro...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, TelaRF35CadastroDeLivros::class.java)
            startActivity(intent)
        }

        // 🔹 Botão Editar
        findViewById<Button>(R.id.btnEditarInformacoes).setOnClickListener {
            val intent = Intent(this, TelaRF35CadastroDeLivros::class.java)
            startActivity(intent)
        }

        // 🔹 Outros botões
        findViewById<Button>(R.id.btnGerenciarUsuario).setOnClickListener {
            startActivity(Intent(this, TelaRF31GerenciamentoDeUsuarios::class.java))
        }

        // 👇 BARRA ADM
        NavigationUtils.setupAdminNavigation(this)
    }
}
