package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaRF10Configuracao : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf10_configuracao)

        val btnRedefinirSenha = findViewById<Button>(R.id.btnRedefinirSenha)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)
        val btnApagarConta = findViewById<Button>(R.id.btnApagarConta)

        // Ir para RF11
        btnRedefinirSenha.setOnClickListener {
            val intent = Intent(this, TelaRF11RedefinirSenha::class.java)
            startActivity(intent)
        }

        // Voltar tela
        btnVoltar.setOnClickListener {
            finish()
        }

        // Apagar conta (simulação)
        btnApagarConta.setOnClickListener {
            Toast.makeText(this, "Conta apagada (simulação)", Toast.LENGTH_SHORT).show()
        }
    }
}