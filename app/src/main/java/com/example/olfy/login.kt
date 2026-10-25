package com.example.olfy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.jvm.java

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtSenha = findViewById<EditText>(R.id.edtSenha)
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)

        btnEntrar.setOnClickListener {
            // Obter os valores digitados e remover espaços em branco nas extremidades
            val nome = edtNome.text.toString().trim()
            val senha = edtSenha.text.toString().trim()

            // Validação sem diferenciar maiúsculas de minúsculas no nome
            val nomeValido = nome.equals("luiz", ignoreCase = true) || nome.equals("maria", ignoreCase = true)
            val senhaValida = senha == "123456789"

            if (nomeValido && senhaValida) {
                // Navega para a tela InicioQuizActivity (vinculada ao layout activity_inicio_quiz)
                val intent = Intent(this, InicioQuizActivity::class.java)
                startActivity(intent)
                finish() // Opcional: fecha a tela de login para o usuário não voltar a ela pressionando o botão voltar
            } else {
                Toast.makeText(this, "Nome ou senha incorretos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
