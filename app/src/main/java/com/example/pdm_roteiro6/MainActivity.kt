package com.example.pdm_roteiro6

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.pdm_roteiro6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("CicloDeVida", "onCreate : criando a activity pela primeira vez.")

        binding.btnEnviar.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("NOME", binding.editNome.text.toString())
            intent.putExtra("EMAIL", binding.editEmail.text.toString())
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("CicloDeVida", "onStart : Activity se torna visível para o usuário.")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CicloDeVida", "onResume : A tela ganhou foco. Interação liberada.")

        val sharedPref = getSharedPreferences("DadosFormulario", Context.MODE_PRIVATE)
        binding.editNome.setText(sharedPref.getString("NOME", ""))
        binding.editEmail.setText(sharedPref.getString("EMAIL", ""))

        Log.d("CicloDeVida", "Dados recuperados do SharedPreferences ")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CicloDeVida", "onPause : A activity perdeu o foco")


        val sharedPref = getSharedPreferences("DadosFormulario", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("NOME", binding.editNome.text.toString())
            putString("EMAIL", binding.editEmail.text.toString())
            apply()
        }

        Log.d("CicloDeVida", "Dados salvos no SharedPreferences ")
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