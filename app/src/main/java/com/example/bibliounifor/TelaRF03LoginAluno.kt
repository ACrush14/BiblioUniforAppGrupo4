package com.example.bibliounifor

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TelaRF03LoginAluno : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf03_loginaluno)

        // IDs corretos do XML
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editSenha = findViewById<EditText>(R.id.editSenha)
        val btnEntrar = findViewById<Button>(R.id.buttonEntrar)
        val textErro = findViewById<TextView>(R.id.textErroLogin)

        btnEntrar.setOnClickListener {

            val email = editEmail.text.toString()
            val senha = editSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {
                textErro.visibility = View.VISIBLE
                textErro.text = "Preencha todos os campos"
            } else {
                textErro.visibility = View.GONE
            }
        }
    }
}