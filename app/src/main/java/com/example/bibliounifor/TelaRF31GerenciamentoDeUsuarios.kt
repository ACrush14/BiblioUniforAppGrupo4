package com.example.bibliouniforappgrupo4_v02

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class TelaRF31GerenciamentoDeUsuarios : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔹 ATENÇÃO: nome do XML correto
        setContentView(TelaRF31GerenciamentoDeUsuarios)

        // 🔹 Pegando os usuários (IDs que você colocou no XML)
        val usuario1 = findViewById<LinearLayout>(R.id.itemUsuario1)
        val usuario2 = findViewById<LinearLayout>(R.id.itemUsuario2)

        // 🔹 Clique no usuário 1
        usuario1.setOnClickListener {
            val intent = Intent(this, TelaRF32UsuariosParaADM::class.java)
            startActivity(intent)
        }

        // 🔹 Clique no usuário 2
        usuario2.setOnClickListener {
            val intent = Intent(this, TelaRF32UsuariosParaADM::class.java)
            startActivity(intent)
        }
    }
}