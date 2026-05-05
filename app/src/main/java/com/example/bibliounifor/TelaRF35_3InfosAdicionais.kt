package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class TelaRF35_3InfosAdicionais : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf35_3_infos_adicionais)

        val btnIrVersoes = findViewById<MaterialButton>(R.id.btnIrVersoes)

        btnIrVersoes.setOnClickListener {
            val intent = Intent(this, TelaRF35_4Versoes::class.java)
            startActivity(intent)
        }

        configurarBarraADM()
    }

    private fun configurarBarraADM() {
        findViewById<ImageView>(R.id.navDashboard).setOnClickListener {
            startActivity(Intent(this, TelaRF30DashboardADM::class.java))
        }
        findViewById<ImageView>(R.id.navFinanceiro).setOnClickListener {
            startActivity(Intent(this, TelaRF36FinanceiroADM::class.java))
        }
        findViewById<ImageView>(R.id.navSolicitacoes).setOnClickListener {
            startActivity(Intent(this, TelaRF33Solicitacoes::class.java))
        }
        findViewById<ImageView>(R.id.navLivrosADM).setOnClickListener {
            startActivity(Intent(this, TelaRF34LivrosCRUD::class.java))
        }
        findViewById<ImageView>(R.id.navUsuarios).setOnClickListener {
            startActivity(Intent(this, TelaRF31GerenciamentoDeUsuarios::class.java))
        }
    }
}