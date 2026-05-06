package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class TelaRF31GerenciamentoDeUsuarios : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf31_gerenciamentousuarios)

        // 🔹 Referenciando os itens incluídos via ID (definidos na tag <include> do XML)
        // Usamos View para evitar erros de cast caso o layout mude
        val usuario1 = findViewById<View>(R.id.itemUsuario1)
        val usuario2 = findViewById<View>(R.id.itemUsuario2)

        // 🔹 Clique no primeiro usuário
        usuario1?.setOnClickListener {
            val intent = Intent(this, TelaRF32UsuariosParaADM::class.java)
            startActivity(intent)
        }

        // 🔹 Clique no segundo usuário
        usuario2?.setOnClickListener {
            val intent = Intent(this, TelaRF32UsuariosParaADM::class.java)
            startActivity(intent)
        }

        // 👇 BARRA ADM
        NavigationUtils.setupAdminNavigation(this)
    }
}