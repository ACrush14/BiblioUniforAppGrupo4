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

        btnTelaCRUD.setOnClickListener {
            val intent = Intent(this, TelaRF30CRUD::class.java)
            startActivity(intent)
        }
    }

}
