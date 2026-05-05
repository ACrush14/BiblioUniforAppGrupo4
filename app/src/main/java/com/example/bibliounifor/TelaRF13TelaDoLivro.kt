package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.bibliounifor.data.AppDatabase
import kotlinx.coroutines.launch

class TelaRF13TelaDoLivro : AppCompatActivity() {
    
    private val database by lazy { AppDatabase.getDatabase(this) }
    private val libroDao by lazy { database.livroDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.telarf13_teladolivro)

        val livroId = intent.getIntExtra("LIVRO_ID", -1)
        if (livroId != -1) {
            carregarDadosDoLivro(livroId)
        }

        findViewById<Button>(R.id.btnVerMaisLivro).setOnClickListener {
            val intent = Intent(this, RF14TelaVerMaisLivro::class.java)
            intent.putExtra("LIVRO_ID", livroId)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnSolicitarLivro).setOnClickListener {
            val intent = Intent(this, TelaRF20Solicitacoes::class.java)
            intent.putExtra("LIVRO_ID", livroId)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnLerLivro).setOnClickListener {
            val intent = Intent(this, TelaRF15LeituraActivity::class.java)
            intent.putExtra("LIVRO_ID", livroId)
            startActivity(intent)
        }
    }

    private fun carregarDadosDoLivro(id: Int) {
        lifecycleScope.launch {
            val livro = libroDao.buscarLivroPorId(id)
            livro?.let {
                findViewById<TextView>(R.id.txtTituloLivroDetalhe).text = it.title
                findViewById<TextView>(R.id.txtAutorLivroDetalhe).text = it.author
                findViewById<TextView>(R.id.txtSobreLivroDetalhe).text = it.content
                
                val imgCapa = findViewById<ImageView>(R.id.imgCapaLivroDetalhe)
                if (it.coverResourceId != 0) {
                    imgCapa.setImageResource(it.coverResourceId)
                } else {
                    imgCapa.setImageResource(R.drawable.osda)
                }
            }
        }
    }
}
