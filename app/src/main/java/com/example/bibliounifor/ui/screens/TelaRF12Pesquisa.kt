package com.example.bibliounifor.ui.screens

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.bibliounifor.R

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
