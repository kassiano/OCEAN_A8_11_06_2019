package br.com.ocean_a8_11_06_2019

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ContatosAdapter : RecyclerView.Adapter<ContatosAdapter.ViewHolder>() {

    private lateinit var items : List<Contato>

    fun updateItems(newItems: List<Contato>){
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contatos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val contato = items[position]

        holder.tvNomeContato.text = contato.nome
        holder.tvTelefonecontato.text = contato.telefone
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val tvNomeContato = itemView.findViewById<TextView>(R.id.tvNomeContato)
        val tvTelefonecontato = itemView.findViewById<TextView>(R.id.tvTelefoneContato)
    }
}