package br.com.ocean_a8_11_06_2019

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contatos = mutableListOf(
            Contato("Kassiano", "(11) 9999 0000"),
            Contato("Jose", "(11) 9999 0000"),
            Contato("Maria", "(11) 9999 0000"),
            Contato("João", "(11) 9999 0000"),
            Contato("Pedro", "(11) 9999 0000")
        )

        repeat(200){
            contatos.add(Contato("Contato ${it}", "0000-0000"))
        }


        val adapter = ContatosAdapter()

        rvContatos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvContatos.adapter = adapter

        adapter.updateItems(contatos)

    }
}
