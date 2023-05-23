package com.example.recpet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recpet.databinding.ActivityCadastroBinding
import com.google.firebase.database.DatabaseReference

class Cadastro : AppCompatActivity() {

    //importar corretamente alt+enter
    private lateinit var binding : ActivityCadastroBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}