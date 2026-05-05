package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class TelaRF35CadastroDeLivros : AppCompatActivity() {

    private lateinit var etData: EditText
    private val REQUEST_CODE_DATA = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf35_cadastro_livro)

        val etTitulo = findViewById<EditText>(R.id.etTitulo)
        val etAutor = findViewById<EditText>(R.id.etAutor)
        val etISBN = findViewById<EditText>(R.id.etISBN)
        etData = findViewById<EditText>(R.id.etData)
        val etQuantidade = findViewById<EditText>(R.id.etQuantidade)
        val btnContinuar = findViewById<MaterialButton>(R.id.btnContinuar)
        val tvErro = findViewById<TextView>(R.id.tvErro)

        // Abrir calendário
        etData.setOnClickListener {
            val intent = Intent(this, TelaRF35_1Data::class.java)
            startActivityForResult(intent, REQUEST_CODE_DATA)
        }

        btnContinuar.setOnClickListener {
            val titulo = etTitulo.text.toString()
            val autor = etAutor.text.toString()
            val isbn = etISBN.text.toString()
            val data = etData.text.toString()
            val quantidade = etQuantidade.text.toString()

            if (titulo.isEmpty() || autor.isEmpty() || isbn.isEmpty() || data.isEmpty() || quantidade.isEmpty()) {
                tvErro.visibility = View.VISIBLE
            } else {
                tvErro.visibility = View.GONE
                val intent = Intent(this, TelaRF35_3InfosAdicionais::class.java)
                startActivity(intent)
            }
        }

        configurarBarraADM()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_DATA && resultCode == RESULT_OK) {
            val dataSelecionada = data?.getStringExtra("dataSelecionada")
            etData.setText(dataSelecionada)
        }
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