package com.example.bibliounifor

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class TelaRF11RedefinirSenha : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf11_redefinirsenha)

        val novaSenha = findViewById<EditText>(R.id.editNovaSenha)
        val confirmarSenha = findViewById<EditText>(R.id.editConfirmarSenha)

        val erroSenha = findViewById<TextView>(R.id.textErroSenha)
        val erroConfirmar = findViewById<TextView>(R.id.textErroConfirmar)

        val botaoSalvar = findViewById<Button>(R.id.buttonSalvar)
        val btnFechar = findViewById<TextView>(R.id.btnFechar)

        btnFechar.setOnClickListener {
            finish()
        }

        botaoSalvar.setOnClickListener {

            val senha = novaSenha.text.toString()
            val confirmar = confirmarSenha.text.toString()

            erroSenha.visibility = View.GONE
            erroConfirmar.visibility = View.GONE

            when {

                senha.isEmpty() || confirmar.isEmpty() -> {
                    Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                }

                senha.length < 8 ||
                        !senha.any { it.isDigit() } ||
                        !senha.any { it.isUpperCase() } -> {

                    erroSenha.text = "Senha inválida"
                    erroSenha.visibility = View.VISIBLE
                }

                senha != confirmar -> {
                    erroConfirmar.text = "As senhas não coincidem"
                    erroConfirmar.visibility = View.VISIBLE
                }

                else -> {
                    Toast.makeText(this, "Senha redefinida com sucesso!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }

        novaSenha.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) erroSenha.visibility = View.GONE
        }

        confirmarSenha.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) erroConfirmar.visibility = View.GONE
        }
    }
}