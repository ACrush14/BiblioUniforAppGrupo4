package com.example.bibliounifornew 

class TelaRF01BemVindo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf01_bemvindo)

        val botaoComecar = findViewById<Button>(R.id.buttonComecar)

        botaoComecar.setOnClickListener {
            val intent = Intent(this, TelaRF02Intermediaria::class.java)
            startActivity(intent)
        }
    }
}