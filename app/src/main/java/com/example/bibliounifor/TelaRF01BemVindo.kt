package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaRF01BemVindo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_rf01_bemvindo)

        val botaoComecar = findViewById<Button>(R.id.buttonComecar)

        botaoComecar.setOnClickListener {
            val intent = Intent(this, TelaRF02Intermediaria::class.java)
            startActivity(intent)
        }
    }
}