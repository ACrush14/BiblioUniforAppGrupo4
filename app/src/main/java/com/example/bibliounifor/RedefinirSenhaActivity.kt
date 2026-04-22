package com.example.bibliouniforapp_final

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RedefinirSenhaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redefinir_senha)

        // CAMPOS
        val novaSenha = findViewById<EditText>(R.id.editNovaSenha)
        val confirmarSenha = findViewById<EditText>(R.id.editConfirmarSenha)

        // TEXTOS DE ERRO
        val erroSenha = findViewById<TextView>(R.id.textErroSenha)
        val erroConfirmar = findViewById<TextView>(R.id.textErroConfirmar)

        // BOTÕES
        val botaoSalvar = findViewById<Button>(R.id.buttonSalvar)
        val btnFechar = findViewById<TextView>(R.id.btnFechar)

        // 👉 FECHAR (X)
        btnFechar.setOnClickListener {
            finish()
        }

        // 👉 BOTÃO SALVAR
        botaoSalvar.setOnClickListener {

            val senha = novaSenha.text.toString()
            val confirmar = confirmarSenha.text.toString()

            // LIMPA ERROS
            erroSenha.visibility = View.GONE
            erroConfirmar.visibility = View.GONE

            when {

                // CAMPOS VAZIOS
                senha.isEmpty() || confirmar.isEmpty() -> {
                    Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                }

                // REGRAS DE SENHA
                senha.length < 8 ||
                        !senha.any { it.isDigit() } ||
                        !senha.any { it.isUpperCase() } -> {

                    erroSenha.text = "A senha deve conter:\n• 8 caracteres\n• 1 número\n• 1 letra maiúscula"
                    erroSenha.visibility = View.VISIBLE
                }

                // SENHAS DIFERENTES
                senha != confirmar -> {
                    erroConfirmar.text = "As senhas estão diferentes"
                    erroConfirmar.visibility = View.VISIBLE
                }

                // SUCESSO
                else -> {
                    Toast.makeText(this, "Senha redefinida com sucesso!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }

        // UX (REMOVE ERRO AO CLICAR)
        novaSenha.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) erroSenha.visibility = View.GONE
        }

        confirmarSenha.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) erroConfirmar.visibility = View.GONE
        }
    }
}