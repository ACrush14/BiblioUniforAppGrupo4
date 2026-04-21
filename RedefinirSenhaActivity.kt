package com.example.bibliounifor // Aqui vai ter o nome do seu pacote original, não mude!

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RedefinirSenhaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redefinir_senha)

        // 1. Encontrando os campos da tela (ID do erro corrigido)
        val edtNovaSenha = findViewById<EditText>(R.id.editTextTextPassword)
        val edtConfirmar = findViewById<EditText>(R.id.editTextTextPassword2)
        val txtErroSenhasDiferentes = findViewById<TextView>(R.id.textViewErro2)
        val btnRedefinir = findViewById<Button>(R.id.RedefinirSenhaADM)
        val txtVoltar = findViewById<TextView>(R.id.textVoltar)

        // 2. Ação ao clicar em "Redefinir Senha"
        btnRedefinir.setOnClickListener {
            val senha1 = edtNovaSenha.text.toString()
            val senha2 = edtConfirmar.text.toString()

            if (senha1.isEmpty() || senha2.isEmpty()) {
                // Se algum campo estiver vazio
                Toast.makeText(this, "Por favor, preencha as duas senhas.", Toast.LENGTH_SHORT).show()
            }
            else if (senha1 != senha2) {
                // Se as senhas não baterem, mostra o aviso em vermelho
                txtErroSenhasDiferentes.visibility = View.VISIBLE
            }
            else {
                // Se deu tudo certo!
                txtErroSenhasDiferentes.visibility = View.INVISIBLE
                Toast.makeText(this, "Senha alterada com sucesso!", Toast.LENGTH_SHORT).show()

                // Quando você criar a tela de Login, basta tirar as "//" das linhas abaixo para redirecionar:
                // val intent = Intent(this, LoginActivity::class.java)
                // startActivity(intent)
                // finish()
            }
        }

        // 3. Ação ao clicar em "< Voltar"
        txtVoltar.setOnClickListener {
            finish() // Fecha essa tela e volta para a anterior
        }
    }
}