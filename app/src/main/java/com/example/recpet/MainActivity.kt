package com.example.recpet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.widget.Toast
import com.example.recpet.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edNome = binding.edUsuario
        val btLogin = binding.btLogin
        val btCadastrar = binding.btCadastrar

        btCadastrar?.setOnClickListener {
            val intent = Intent( this, CadastroActivity::class.java )
            startActivity(intent)
        }

        btLogin.setOnClickListener {

//            if (edNome.text.toString() == "Admin") {
//                val inten = Intent(this, CadastroActivity::class.java)
                //val inten = Intent(this, Tela2Activity::class.java)
                //val texto = edNome.text.toString()
                //startActivity(inten)
                //testando escrita com banco de dados
                val database = Firebase.database
                val myRef = database.getReference("teste")

                myRef.setValue("Olá Neo!")


                //else{
                //    Toast.makeText(this, R.string.msgError, Toast.LENGTH_SHORT).show()
                }
            }
            //setContentView(R.layout.activity_main)
        }
}