package com.example.recpet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recpet.databinding.ActivityCadastroBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import layout.UsuarioModelo

class CadastroActivity : AppCompatActivity() {

    //importar corretamente alt+enter
    private lateinit var binding: ActivityCadastroBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var edPersonName = binding.edPersonName
        var edDate = binding.edDate
        var edCPF = binding.edCPF
        var edEndereco = binding.edEndereco
        var edCEL = binding.edCEL
        var edEMAIL = binding.edEMAIL
        var edPasswordCad = binding.edPasswordCad
        var btCadastro = binding.btCadastro

        dbRef = FirebaseDatabase.getInstance().getReference("Usuário")

        btCadastro.setOnClickListener {
            val userName = edPersonName.text.toString()
            val userDate = edDate.text.toString()
            val userCPF = edCPF.text.toString()
            val userEndereco = edEndereco.text.toString()
            val userCelular = edCEL.text.toString()
            val userEmail = edEMAIL.text.toString()
            val userSenha = edPasswordCad.text.toString()

            if (userName.isEmpty()) {
                edPersonName.error = "Por favor, escreva seu nome"
            }
            if (userDate.isEmpty()) {
                edDate.error = "Por favor, digite sua data de nascimento"
            }
            if (userCPF.isEmpty()) {
                edCPF.error = "Por favor, diga seu CPF"
            }
            if (userEndereco.isEmpty()) {
                edEndereco.error = "Por favor, escreva seu endereço completo"
            }
            if (userCelular.isEmpty()) {
                edCEL.error = "Por favor, diga seu número"
            }
            if (userEmail.isEmpty()) {
                edEMAIL.error = "Por favor, escreva seu email"
            }
            if (userSenha.isEmpty()) {
                edPasswordCad.error = "Por favor, digite uma senha"
            }

            val userId = dbRef.push().key!!

            val usuario = UsuarioModelo(
                userId,
                userName,
                userDate,
                userCPF,
                userEndereco,
                userCelular,
                userEmail,
                userSenha
            )

            dbRef.child(userId).setValue(usuario)
                .addOnCompleteListener {
                    Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show()

                    edPersonName.text.clear()
                    edDate.text.clear()
                    edCPF.text.clear()
                    edEndereco.text.clear()
                    edCEL.text.clear()
                    edEMAIL.text.clear()
                    edPasswordCad.text.clear()

                }.addOnFailureListener { err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                }

        }
    }
}