package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaRF08ConfirmarRedefinirSenha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.telarf08_confirmar_redefinir_senha)

        val buttonVoltar = findViewById<Button>(R.id.btnIrLogin)

        buttonVoltar.setOnClickListener {
            val intent = Intent(this, TelaRF03LoginAluno::class.java)
            startActivity(intent)
        }

    }
}