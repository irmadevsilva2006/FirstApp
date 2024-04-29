package com.analara.firstapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.analara.firstapp.R
import com.analara.firstapp.databinding.ListItemPessoaBinding
import com.analara.firstapp.service.model.Pessoa

class PessoaAdapter(pessoas: List<Pessoa>?, private val clickListListener: (Pessoa) -> Unit):
   RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder>(){

       // Criar uma lista vazia de pessoas
       private var pessoaList: List<Pessoa> = arrayListOf()
    class PessoaViewHolder(private val binding: ListItemPessoaBinding) :
        RecyclerView.ViewHolder(binding.root){

            // Carrega as informações da pessoa na lista
            fun bind(pessoa: Pessoa, clickListListener: (Pessoa) -> Unit){
                binding.tvNome.text = pessoa.nome
                binding.tvIdade.text = pessoa.idade.toString() + "anos"
               binding.tvFaixaEtaria.text = pessoa.faixaEtaria


                // Metodo 1 para esconder ou mostrar uma imagem
                if(pessoa.sexo == "Masculino"){
                    binding.imgBoy.visibility = View.VISIBLE
                    binding.imgGirl.visibility= View.GONE
                } else{
                    binding.imgGirl.visibility = View.VISIBLE
                    binding.imgBoy.visibility = View.GONE
                }

                // Metodo 2 para mostrar uma imagem desejada
//                if (pessoa.sexo == "Masculino"){
//                    binding.imgBoy.setImageResource(R.drawable.baseline_man_24)
//                }else {
//                    binding.imgGirl.setImageResource(R.drawable.baseline_woman_24)
//                }

                // Configurar o click de algum item da lista
                binding.root.setOnClickListener {
                    clickListListener(pessoa)
                }
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        // Configura binding da lista
        val listItemPessoaBinding =
            ListItemPessoaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PessoaViewHolder(listItemPessoaBinding)

    }

    override fun getItemCount(): Int {
        return pessoaList.count()
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
       holder.bind(pessoaList[position], clickListListener)
    }

    //Carrega a lista de pessoas para serem exibidas
    fun updatePessoas(list:List<Pessoa>){
        pessoaList = list
        notifyDataSetChanged()
    }
}