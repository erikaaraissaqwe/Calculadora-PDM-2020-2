package com.example.calculadorapdm20202

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_configuracoes.*

class ConfiguracoesActivity : AppCompatActivity() {
    private lateinit var configuracoes: Configuracoes
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracoes)
        supportActionBar?.subtitle = "Configurações"
        configuracoes =  intent.getParcelableExtra<Configuracoes>(MainActivity.EXTRA_CONFIGURACOES) ?: Configuracoes(false)
        tipoCalculadoraRg.check(if(configuracoes.avancada) R.id.avancadoRb else R.id.normalRb)
    }
    fun onClick(view: View){
        if(view.id == R.id.salvarBt){
            configuracoes.avancada = avancadoRb.isChecked
            val resultadoIntent: Intent = Intent()
            resultadoIntent.putExtra(MainActivity.EXTRA_CONFIGURACOES, configuracoes)
            setResult(RESULT_OK, resultadoIntent)
            finish()
        }
    }
}