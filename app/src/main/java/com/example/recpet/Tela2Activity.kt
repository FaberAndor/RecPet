package com.example.recpet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recpet.databinding.ActivityTela2Binding

class Tela2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTela2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTela2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuarioNome = binding.tvUsuarioNome
        val nome = intent.getStringExtra("nome")
        usuarioNome.text = nome
        //setContentView(R.layout.activity_tela2)

        val btParaTela3 = binding.button

        btParaTela3.setOnClickListener {
            val intent = Intent( this, Tela3Activity::class.java )
        startActivity(intent)
        }
    }
}