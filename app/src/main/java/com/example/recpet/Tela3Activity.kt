package com.example.recpet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recpet.databinding.ActivityTela2Binding
import com.example.recpet.databinding.ActivityTela3Binding

class Tela3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTela3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityTela3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val btParaLista = binding.btLista

        btParaLista.setOnClickListener {
            val intent = Intent( this, ListaPessoasActivity::class.java )
            startActivity(intent)
        }
    }

}
