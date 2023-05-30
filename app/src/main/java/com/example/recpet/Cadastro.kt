package com.example.recpet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recpet.databinding.ActivityCadastroBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Cadastro : AppCompatActivity() {

    //importar corretamente alt+enter
    private lateinit var binding : ActivityCadastroBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var edPersonName = binding.edPersonName
        var edDate = binding.edDate
        var edID = binding.edID
        var edEndereco = binding.edEndereco
        var edCEL = binding.edCEL
        var edEMAIL = binding.edEMAIL
        var edPasswordCad = binding.edPasswordCad
        var  btCadastro = binding.btCadastro

        dbRef = FirebaseDatabase.getInstance().getReference("RecPet")

        btCadastro.setOnClickListener{
            val userName = edPersonName.text.toString()
            val empCargo = edCargo.text.toString()
            val empSalario = edSalario.text.toString()

            if(userName.isEmpty()){
                edPersonName.error = "Por favor insira um nome"
            }
            if(empCargo.isEmpty()){
                edCargo.error = "Por favor insira um Cargo"
            }
            if(empSalario.isEmpty()){
                edSalario.error = "Por favor insira um Salário"
            }

    }
}