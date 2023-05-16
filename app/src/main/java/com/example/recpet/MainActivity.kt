package com.example.recpet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.widget.Toast
import com.example.recpet.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edNome = binding.edUsuario
        val btLogin = binding.btLogin

        btLogin.setOnClickListener {
            //if(edNome.text.toString()=="Faber") {
                val inten = Intent(this, Tela2Activity::class.java)
                val texto = edNome.text.toString()
                inten.putExtra("nome", texto)
                startActivity(inten)

            //teste
            val database = Firebase.database
            val myRef = database.getReference("message")

            myRef.setValue("Hello, World!")
           // }
           // else{
            //    Toast.makeText(this, R.string.msgError, Toast.LENGTH_SHORT).show()
           // }
        }
        //setContentView(R.layout.activity_main)
    }
}