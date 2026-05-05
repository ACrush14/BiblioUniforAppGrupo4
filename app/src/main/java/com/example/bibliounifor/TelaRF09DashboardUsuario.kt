package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class TelaRF09DashboardUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf09_dashboardusuario)

        // Configura Navegação Superior (Sino e Engrenagem) e Inferior (6 ícones)
        NavigationUtils.setupTopBar(this)
        NavigationUtils.setupBottomNavigation(this)

        // Botões de ação do conteúdo central
        val btnProcurarLivros = findViewById<MaterialButton>(R.id.btnProcurarLivros)
        val btnMinhaLivraria = findViewById<MaterialButton>(R.id.btnMinhaLivrariaDash)
        val btnListaDesejo = findViewById<MaterialButton>(R.id.btnListaDesejoDash)
        val btnAmigos = findViewById<MaterialButton>(R.id.btnAmigosDash)
        val btnHistorico = findViewById<MaterialButton>(R.id.btnHistoricoDash)
        val btnStatusAluguel = findViewById<MaterialButton>(R.id.btnStatusAluguelDash)
        val btnSair = findViewById<MaterialButton>(R.id.btnSairDash)

        btnProcurarLivros.setOnClickListener {
            startActivity(Intent(this, TelaRF12TelaDePesquisa::class.java))
        }

        btnMinhaLivraria.setOnClickListener {
            startActivity(Intent(this, TelaRF16MinhaLivrariaActivity::class.java))
        }

        btnListaDesejo.setOnClickListener {
            startActivity(Intent(this, TelaRF17ListaDesejosActivity::class.java))
        }

        btnAmigos.setOnClickListener {
            startActivity(Intent(this, TelaRF18::class.java))
        }

        btnHistorico.setOnClickListener {
            startActivity(Intent(this, TelaRF22Historico::class.java))
        }

        btnStatusAluguel.setOnClickListener {
            startActivity(Intent(this, TelaRF19::class.java))
        }
        
        btnSair.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
