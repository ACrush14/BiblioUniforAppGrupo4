package com.example.bibliounifor.ui.screens

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bibliounifor.R

class `29GoogleADM` : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.`29_google_adm`)

        val edtEmailGoogle = findViewById<EditText>(R.id.edtEmailGoogle)
        val btnProxima = findViewById<Button>(R.id.btnProxima)
        val txtVoltar = findViewById<TextView>(R.id.txtCriarContaGoogle)

        // Ação do Botão "Próxima" (RF29.2)
        btnProxima.setOnClickListener {
            val email = edtEmailGoogle.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, "Digite seu e-mail do Google", Toast.LENGTH_SHORT).show()
            } else {
                // Simula o login com sucesso
                Toast.makeText(this, "Conectado com a conta: $email", Toast.LENGTH_LONG).show()
            }
        }

        // Simula o botão de voltar ou criar conta
        txtVoltar.setOnClickListener {
            finish() // Retorna para a tela anterior
        }
    }
}
