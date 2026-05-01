package com.example.teste

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RF12TelaDePesquisa : AppCompatActivity() {

    lateinit var bntPorTitulo: Button
    lateinit var bntPorISBN: Button
    lateinit var bntPesquisa: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.telarf12_teladepesquisa)




    }
}
