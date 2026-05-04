package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bibliounifor.data.AppDatabase
import com.example.bibliounifor.data.EntidadeLivro
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.ChipGroup
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TelaRF12TelaDePesquisa : AppCompatActivity() {

    private lateinit var adapter: LivroAdapter
    private val database by lazy { AppDatabase.getDatabase(this) }
    private val livroDao by lazy { database.livroDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf12_teladepesquisa)

        setupRecyclerView()
        setupListeners()
        popularBancoDeDados()
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerLivros)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        
        adapter = LivroAdapter(emptyList()) { livro ->
            val intent = Intent(this, TelaRF13TelaDoLivro::class.java)
            intent.putExtra("LIVRO_ID", livro.id)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        lifecycleScope.launch {
            livroDao.buscarTodosLivros().collectLatest { lista ->
                adapter.updateData(lista)
            }
        }
    }

    private fun setupListeners() {
        val editPesquisa = findViewById<EditText>(R.id.editPesquisa)
        val btnPesquisar = findViewById<MaterialButton>(R.id.btnPesquisar)
        val btnFiltro = findViewById<ImageView>(R.id.btnFiltro)

        btnPesquisar.setOnClickListener {
            realizarPesquisa(editPesquisa.text.toString())
        }

        editPesquisa.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                realizarPesquisa(editPesquisa.text.toString())
                true
            } else false
        }

        btnFiltro.setOnClickListener {
            mostrarPopupFiltro()
        }

        findViewById<ImageView>(R.id.navHome)?.setOnClickListener {
            startActivity(Intent(this, TelaRF09DashboardUsuario::class.java))
            finish()
        }
    }

    private fun realizarPesquisa(query: String) {
        lifecycleScope.launch {
            val formatQuery = "%$query%"
            livroDao.pesquisarLivros(formatQuery).collectLatest { resultados ->
                adapter.updateData(resultados)
            }
        }
    }

    private fun mostrarPopupFiltro() {
        val dialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.layout_filtro_pesquisa, null)
        dialog.setContentView(view)

        view.findViewById<MaterialButton>(R.id.btnSalvarFiltro).setOnClickListener {
            dialog.dismiss()
        }
        
        view.findViewById<MaterialButton>(R.id.btnLimparFiltro).setOnClickListener {
            view.findViewById<ChipGroup>(R.id.cgDisponibilidade).clearCheck()
            view.findViewById<ChipGroup>(R.id.cgCategoria).clearCheck()
        }

        dialog.show()
    }

    private fun popularBancoDeDados() {
        lifecycleScope.launch {
            if (livroDao.getCount() == 0) {
                val livrosParaInserir = listOf(
                    EntidadeLivro(
                        title = "O Alienista",
                        author = "Machado de Assis",
                        isbn = "978850101",
                        category = "Clássico",
                        content = "Publicado originalmente em 1882, O Alienista é uma das obras mais famosas de Machado de Assis, contando a história do Dr. Simão Bacamarte.",
                        coverResourceId = R.drawable.osda
                    ),
                    EntidadeLivro(
                        title = "O Alienista (Edição Especial)",
                        author = "Machado de Assis",
                        isbn = "978850102",
                        category = "Clássico",
                        content = "Esta edição especial traz notas comentadas sobre a loucura na visão de Bacamarte.",
                        coverResourceId = R.drawable.osda
                    ),
                    EntidadeLivro(
                        title = "Dom Casmurro",
                        author = "Machado de Assis",
                        isbn = "978850103",
                        category = "Clássico",
                        content = "A história de Bentinho e Capitu, e a eterna dúvida: houve traição?",
                        coverResourceId = R.drawable.osda
                    ),
                    EntidadeLivro(
                        title = "O Senhor dos Anéis",
                        author = "J.R.R. Tolkien",
                        isbn = "978850104",
                        category = "Fantasia",
                        content = "Um anel para a todos governar. A jornada épica de Frodo para destruir o Um Anel.",
                        coverResourceId = R.drawable.osda
                    ),
                    EntidadeLivro(
                        title = "O Hobbit",
                        author = "J.R.R. Tolkien",
                        isbn = "978850105",
                        category = "Fantasia",
                        content = "A aventura de Bilbo Bolseiro e um grupo de anões rumo à Montanha Solitária.",
                        coverResourceId = R.drawable.osda
                    ),
                    EntidadeLivro(
                        title = "Memórias Póstumas de Brás Cubas",
                        author = "Machado de Assis",
                        isbn = "978850106",
                        category = "Clássico",
                        content = "Um defunto autor que narra suas memórias após a morte com ironia e pessimismo.",
                        coverResourceId = R.drawable.osda
                    )
                )
                
                livrosParaInserir.forEach { livroDao.inserirLivro(it) }
            }
        }
    }
}
