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

        val btnRedefinir = findViewById<Button>(R.id.btnRedefinirSenha)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar1)
        val btnApagar = findViewById<Button>(R.id.btnApagarConta)

        btnRedefinir.setOnClickListener {
            startActivity(Intent(this, TelaRF11RedefinirSenha::class.java))
        }

        btnVoltar.setOnClickListener {
            finish()
        }

        btnApagar.setOnClickListener {
            Toast.makeText(this, "Conta apagada (simulação)", Toast.LENGTH_SHORT).show()
        }
    }
}