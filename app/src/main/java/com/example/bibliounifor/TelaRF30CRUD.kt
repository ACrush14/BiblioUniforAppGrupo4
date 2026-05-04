package com.example.bibliounifor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TelaRF30CRUD : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // The extra "telarf30_3_crud)" was removed to fix the syntax error
        setContentView(R.layout.telarf30_dashboard_adm)
    }
}