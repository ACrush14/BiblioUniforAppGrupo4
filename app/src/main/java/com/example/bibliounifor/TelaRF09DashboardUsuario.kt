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

        // Botões originais
        val btnConfig = findViewById<ImageView>(R.id.btnConfig)
        val btnProcurarLivros = findViewById<MaterialButton>(R.id.btnProcurarLivros)
        val profileImage = findViewById<ImageView>(R.id.profile_image)

        // Novos botões integrados do Perfil
        val btnMinhaLivraria = findViewById<MaterialButton>(R.id.btnMinhaLivrariaDash)
        val btnListaDesejo = findViewById<MaterialButton>(R.id.btnListaDesejoDash)
        val btnAmigos = findViewById<MaterialButton>(R.id.btnAmigosDash)
        val btnHistorico = findViewById<MaterialButton>(R.id.btnHistoricoDash)
        val btnStatusAluguel = findViewById<MaterialButton>(R.id.btnStatusAluguelDash)
        val btnSalvar = findViewById<MaterialButton>(R.id.btnSalvarDash)
        val btnSair = findViewById<MaterialButton>(R.id.btnSairDash)

        // Engrenagem -> Configuração (RF10)
        btnConfig.setOnClickListener {
            startActivity(Intent(this, TelaRF10Configuracao::class.java))
        }

        // Botão Procurar Livros -> Tela de Pesquisa (RF12)
        btnProcurarLivros.setOnClickListener {
            startActivity(Intent(this, TelaRF12TelaDePesquisa::class.java))
        }

        // --- CONEXÕES ---

        // Minha Livraria -> RF16 (Compose)
        btnMinhaLivraria.setOnClickListener {
            startActivity(Intent(this, TelaRF16MinhaLivrariaActivity::class.java))
        }

        // Lista de Desejo -> RF17 (Compose)
        btnListaDesejo.setOnClickListener {
            startActivity(Intent(this, TelaRF17ListaDesejosActivity::class.java))
        }

        // Amigos -> RF18 (Compose)
        btnAmigos.setOnClickListener {
            startActivity(Intent(this, TelaRF18::class.java))
        }

        // Histórico -> RF22 (XML)
        btnHistorico.setOnClickListener {
            startActivity(Intent(this, TelaRF22Historico::class.java))
        }

        // Status Aluguel -> RF19 (Compose)
        btnStatusAluguel.setOnClickListener {
            startActivity(Intent(this, TelaRF19::class.java))
        }
        
        // Sair da Conta
        btnSair.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        
        // Configuração dos itens da barra inferior
        findViewById<ImageView>(R.id.navSearch)?.setOnClickListener {
            startActivity(Intent(this, TelaRF12TelaDePesquisa::class.java))
        }

        findViewById<ImageView>(R.id.navHome)?.setOnClickListener {
            // Já estamos na Home/Dash
        }
        
        findViewById<ImageView>(R.id.navPerfil)?.setOnClickListener {
            // Conforme solicitado, o ícone de pessoinha leva para Gestão de Amigos (RF18)
            startActivity(Intent(this, TelaRF18::class.java))
        }
    }
}
