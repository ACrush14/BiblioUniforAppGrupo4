package com.example.bibliounifor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent

class TelaRF30DashboardADM : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.telarf30_dashboard_adm)

        val btnTelaCRUD = findViewById<Button>(R.id.btnTelaCRUD)
        val btnVerAlugueis = findViewById<Button>(R.id.btnVerAlugueis)
        val btnVerAtrasos = findViewById<Button>(R.id.btnVerAtrasos)
        val btnVerCadastros = findViewById<Button>(R.id.btnVerCadastros)
        val btnVerSolicitacoes = findViewById<Button>(R.id.btnVerSolicitacoes)
        val btnVerRenovacoes = findViewById<Button>(R.id.btnVerRenovacoes)

        btnTelaCRUD.setOnClickListener {
            // Alterado para ir para a TelaRF34LivrosCRUD conforme solicitado
            val intent = Intent(this, TelaRF34LivrosCRUD::class.java)
            startActivity(intent)
        }

        btnVerAlugueis.setOnClickListener {
            val intent = Intent(this, TelaRF38ListaAlugueisADM::class.java)
            startActivity(intent)
        }

        btnVerAtrasos.setOnClickListener {
            val intent = Intent(this, TelaRF36FinanceiroADM::class.java)
            startActivity(intent)
        }

        btnVerCadastros.setOnClickListener {
            val intent = Intent(this, TelaRF35CadastroDeLivros::class.java)
            startActivity(intent)
        }

        btnVerSolicitacoes.setOnClickListener {
            val intent = Intent(this, TelaRF33Solicitacoes::class.java)
            startActivity(intent)
        }

    }

}
