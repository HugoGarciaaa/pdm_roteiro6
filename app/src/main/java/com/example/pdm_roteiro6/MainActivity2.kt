package com.example.pdm_roteiro6
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.pdm_roteiro6.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("CicloDeVida", "onCreate : criando a activity pela primeira vez.")

        val nome = intent.getStringExtra("NOME") ?: ""
        val email = intent.getStringExtra("EMAIL") ?: ""

        binding.textNome.text = "Nome: $nome"
        binding.textEmail.text = "Email: $email"
    }

    override fun onStart() {
        super.onStart()
        Log.d("CicloDeVida", "onStart : Activity se torna visível para o usuário.")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CicloDeVida", "onResume : A tela ganhou foco. Interação liberada.")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CicloDeVida", "onPause : A activity perdeu o foco")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CicloDeVida", "onStop : A activity não está mais visível")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CicloDeVida", "onDestroy: A activity foi destruída.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("CicloDeVida", "onRestart: A activity está sendo reiniciada.")
    }
}