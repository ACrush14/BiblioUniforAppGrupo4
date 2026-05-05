package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton // Importação do botão

class TelaRF40ConfigADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf40_config_adm)

        // 👇 BARRA ADM
        val navDashboard = findViewById<ImageView>(R.id.navDashboard)
        val navFinanceiro = findViewById<ImageView>(R.id.navFinanceiro)
        val navSolicitacoes = findViewById<ImageView>(R.id.navSolicitacoes)
        val navLivrosADM = findViewById<ImageView>(R.id.navLivrosADM)
        val navUsuarios = findViewById<ImageView>(R.id.navUsuarios)

        navDashboard.setOnClickListener {
            startActivity(Intent(this, TelaRF30DashboardADM::class.java))
        }

        navFinanceiro.setOnClickListener {
            startActivity(Intent(this, TelaRF36FinanceiroADM::class.java))
        }

        navSolicitacoes.setOnClickListener {
            startActivity(Intent(this, TelaRF33Solicitacoes::class.java))
        }

        navLivrosADM.setOnClickListener {
            startActivity(Intent(this, TelaRF34LivrosCRUD::class.java))
        }

        navUsuarios.setOnClickListener {
            startActivity(Intent(this, TelaRF31GerenciamentoDeUsuarios::class.java))
        }

        // 1. Encontrar o botão pelos IDs que criamos no XML
        val btnVoltarDashboard = findViewById<MaterialButton>(R.id.btnVoltarDashboard)

        // 3. Criar a ação de clique para o BOTÃO
        btnVoltarDashboard.setOnClickListener {
            val intent = Intent(this, TelaRF30DashboardADM::class.java)
            startActivity(intent)
        }
    }
}