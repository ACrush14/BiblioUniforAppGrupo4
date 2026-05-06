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

        // 👇 BARRA ADM
        NavigationUtils.setupAdminNavigation(this)
    }
}