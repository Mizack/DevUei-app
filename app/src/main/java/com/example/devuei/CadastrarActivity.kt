package com.example.devuei

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CadastrarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)

        val btnVoltar = findViewById<Button>(R.id.voltar_logar)
        val cadastrar = findViewById<Button>(R.id.realizar_cadastro)

        val nome = findViewById<EditText>(R.id.txt_nome_cadastro)
        val email = findViewById<EditText>(R.id.txt_email_cadastro)
        val senha = findViewById<EditText>(R.id.txt_senha_cadastro)

        cadastrar.setOnClickListener {
            val salvarDados = this.getSharedPreferences("usuarioDevuei",Context.MODE_PRIVATE)
            val editor = salvarDados.edit()

            editor.putString("email",email.editableText.toString())
            editor.putString("nome",nome.editableText.toString())
            editor.putString("senha",senha.editableText.toString())
            editor.apply()

            Toast.makeText(this, "Gravada com sucesso! Por favor, retorne à tela de login.", Toast.LENGTH_SHORT).show()
        }

        btnVoltar.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
}