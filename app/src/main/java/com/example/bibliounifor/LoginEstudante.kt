package com.example.bibliouniforapp_final

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginEstudante : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_estudante)

        // CAMPOS
        val email = findViewById<EditText>(R.id.editEmail)
        val senha = findViewById<EditText>(R.id.editSenha)

        // BOTÃO
        val botaoEntrar = findViewById<Button>(R.id.buttonEntrar)

        // TEXTOS
        val erro = findViewById<TextView>(R.id.textErroLogin)
        val criarConta = findViewById<TextView>(R.id.textCriarConta)
        val voltar = findViewById<TextView>(R.id.textVoltar)
        val esqueceuSenha = findViewById<TextView>(R.id.textEsqueceuSenha)

        botaoEntrar.setOnClickListener {

            val textoEmail = email.text.toString().trim()
            val textoSenha = senha.text.toString().trim()

            erro.visibility = View.GONE

            if (textoEmail.isEmpty() || textoSenha.isEmpty()) {

                erro.text = "Preencha todos os campos"
                erro.visibility = View.VISIBLE

            } else if (textoEmail != "teste@email.com" || textoSenha != "12345678") {

                erro.text = "E-mail ou senha incorretos"
                erro.visibility = View.VISIBLE

            } else {

                Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
            }
        }

        criarConta.setOnClickListener {
            Toast.makeText(this, "Ir para tela de cadastro", Toast.LENGTH_SHORT).show()
        }

        esqueceuSenha.setOnClickListener {
            Toast.makeText(this, "Recuperação de senha em breve", Toast.LENGTH_SHORT).show()
        }

        voltar.setOnClickListener {
            finish()
        }

        // UX MELHOR
        email.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) erro.visibility = View.GONE
        }

        senha.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) erro.visibility = View.GONE
        }
    }
}