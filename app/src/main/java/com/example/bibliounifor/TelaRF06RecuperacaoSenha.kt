package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaRF06RecuperacaoSenha : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf06_recuperacao_senha)

        val etEmail = findViewById<EditText>(R.id.editTextEmaiREC)
        val btnEnviar = findViewById<Button>(R.id.buttonEnviarCOD)
        val btnVoltar = findViewById<Button>(R.id.buttonVoltarLog)

        btnEnviar.setOnClickListener {
            val email = etEmail.text.toString()
            if (email.isNotEmpty()) {
                Toast.makeText(this, "Código enviado para $email", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor, insira seu e-mail", Toast.LENGTH_SHORT).show()
            }
        }

        btnVoltar.setOnClickListener {
            val intent = Intent(this, TelaRF03LoginAluno::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }

        bntEnviar.setOnClickListener {
            val intent = Intent(this, TelaRF07ValidacaoDeCodigo::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
    }
}
