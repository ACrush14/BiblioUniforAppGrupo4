package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaRF35CadastroDeLivros : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf35_cadastro_livro)

        // 👇 CAMPOS
        val etTitulo = findViewById<EditText>(R.id.etTitulo)
        val etAutor = findViewById<EditText>(R.id.etAutor)
        val etISBN = findViewById<EditText>(R.id.etISBN)
        val etData = findViewById<EditText>(R.id.etData)
        val etQuantidade = findViewById<EditText>(R.id.etQuantidade)

        val btnContinuar = findViewById<Button>(R.id.btnContinuar)
        val tvErro = findViewById<TextView>(R.id.tvErro)

        btnContinuar.setOnClickListener {

            val titulo = etTitulo.text.toString()
            val autor = etAutor.text.toString()
            val isbn = etISBN.text.toString()
            val data = etData.text.toString()
            val quantidade = etQuantidade.text.toString()

            // Validação
            if (titulo.isEmpty() || autor.isEmpty() || isbn.isEmpty() || data.isEmpty() || quantidade.isEmpty()) {
                tvErro.visibility = View.VISIBLE
            } else {
                tvErro.visibility = View.GONE

                Toast.makeText(this, "Livro cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
            }
        }

        // 👇 BARRA ADM
        val navUsuarios = findViewById<ImageView>(R.id.navUsuarios)
        val navSolicitacoes = findViewById<ImageView>(R.id.navSolicitacoes)
        val navLivros = findViewById<ImageView>(R.id.navLivrosADM)

        // Ir para RF31
        navUsuarios.setOnClickListener {
            val intent = Intent(this, TelaRF31GerenciamentoDeUsuarios::class.java)
            startActivity(intent)
        }

        // Ir para RF33
        navSolicitacoes.setOnClickListener {
            val intent = Intent(this, TelaRF33Solicitacoes::class.java)
            startActivity(intent)
        }

        // Ir para RF34
        navLivros.setOnClickListener {
            val intent = Intent(this, TelaRF34LivrosCRUD::class.java)
            startActivity(intent)
        }
    }
}