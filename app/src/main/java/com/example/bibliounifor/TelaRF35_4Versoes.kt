package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class TelaRF35_4Versoes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf35_4_versoes)

        val btnSalvarLivro = findViewById<MaterialButton>(R.id.btnSalvarLivro)

        btnSalvarLivro.setOnClickListener {
            exibirPopupSucesso()
        }

        configurarBarraADM()
    }

    private fun exibirPopupSucesso() {
        // Inflar o layout do popup
        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.telarf35_6_popup_sucesso, null)

        val builder = AlertDialog.Builder(this)
        builder.setView(view)
        builder.setCancelable(false)

        val dialog = builder.create()
        // Remover fundo padrão para respeitar os cantos arredondados do nosso XML se necessário
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val btnVoltarPopup = view.findViewById<MaterialButton>(R.id.btnVoltarPopup)
        btnVoltarPopup.setOnClickListener {
            dialog.dismiss()
            // Voltar para a tela de CRUD de livros
            val intent = Intent(this, TelaRF34LivrosCRUD::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }

        dialog.show()
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