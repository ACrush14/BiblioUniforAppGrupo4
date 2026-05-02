package com.example.bibliounifor

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GoogleLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_login)

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

                // Aqui você colocaria o código para ir para a tela principal do app
                // val intent = Intent(this, MenuPrincipalActivity::class.java)
                // startActivity(intent)
                // finish()
            }
        }

        // Simula o botão de voltar ou criar conta
        txtVoltar.setOnClickListener {
            finish() // Retorna para a tela anterior
        }
    }
}