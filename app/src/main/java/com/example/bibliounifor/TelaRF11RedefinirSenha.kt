package com.example.bibliounifor

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaRF11RedefinirSenha : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf11_redefinirsenha)

        val editNovaSenha = findViewById<EditText>(R.id.editNovaSenha)
        val editConfirmarSenha = findViewById<EditText>(R.id.editConfirmarSenha)
        val btnSalvar = findViewById<Button>(R.id.buttonSalvar)

        val erroSenha = findViewById<TextView>(R.id.textErroSenha)
        val erroConfirmar = findViewById<TextView>(R.id.textErroConfirmar)

        btnSalvar.setOnClickListener {

            val senha = editNovaSenha.text.toString()
            val confirmar = editConfirmarSenha.text.toString()

            // Resetar erros
            erroSenha.visibility = View.GONE
            erroConfirmar.visibility = View.GONE

            var valido = true

            // Validação 1: tamanho mínimo
            if (senha.length < 8) {
                erroSenha.visibility = View.VISIBLE
                erroSenha.text = "Senha deve ter pelo menos 8 caracteres"
                valido = false
            }

            // Validação 2: confirmação
            if (senha != confirmar) {
                erroConfirmar.visibility = View.VISIBLE
                erroConfirmar.text = "As senhas não coincidem"
                valido = false
            }

            // Se tudo ok
            if (valido) {
                Toast.makeText(this, "Senha alterada com sucesso!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}