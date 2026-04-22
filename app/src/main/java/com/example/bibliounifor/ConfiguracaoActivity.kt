package com.example.bibliouniforapp_final

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ConfiguracaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracao)

        // BOTÕES
        val btnRedefinir = findViewById<Button>(R.id.btnRedefinirSenha)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)
        val btnApagar = findViewById<Button>(R.id.btnApagarConta)

        // 👉 IR PARA TELA DE REDEFINIR SENHA (TELA 11)
        btnRedefinir.setOnClickListener {
            val intent = Intent(this, RedefinirSenhaActivity::class.java)
            startActivity(intent)
        }

        // 👉 VOLTAR
        btnVoltar.setOnClickListener {
            finish()
        }

        // 👉 APAGAR CONTA (SIMULAÇÃO)
        btnApagar.setOnClickListener {
            Toast.makeText(this, "Conta apagada (simulação)", Toast.LENGTH_SHORT).show()
        }
    }
}