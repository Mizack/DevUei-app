package com.example.devuei

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogar = findViewById<Button>(R.id.logar)
        val btnCadastrar = findViewById<Button>(R.id.cadastrar)

        val inputEmail = findViewById<EditText>(R.id.txt_email)
        val inputSenha = findViewById<EditText>(R.id.txt_senha)

        btnLogar.setOnClickListener {
            if (inputEmail.text.toString().equals("") || inputSenha.text.toString().equals("")){
                Toast.makeText(this, "Por favor, preencha os campos para seguir com a operação", Toast.LENGTH_SHORT).show()
            }else{
                val recuperarLogin = this.getSharedPreferences("usuarioDevuei", Context.MODE_PRIVATE)
                val nome = recuperarLogin.getString("nome","")
                val email = recuperarLogin.getString("email","")
                val senha = recuperarLogin.getString("senha","")
                if (inputEmail.text.toString().equals(email) && inputSenha.text.toString().equals(senha)){
                    Toast.makeText(this, "Seja bem vindo, "+nome, Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Por favor, verifique seus dados novamente ou realize o cadastro.", Toast.LENGTH_SHORT).show()
                }


            }


        }

        btnCadastrar.setOnClickListener {
            val i = Intent(this,CadastrarActivity::class.java)
            startActivity(i)
        }
    }
}