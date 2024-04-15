package com.analara.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.analara.firstapp.R
import com.analara.firstapp.databinding.FragmentAllPessoaBinding
import com.analara.firstapp.view.adapter.PessoaAdapter
import com.analara.firstapp.viewmodel.AllPessoasViewModel

class AllPessoaFragment : Fragment() {

    // Chamar a viewmodel
    private val viewModel: AllPessoasViewModel by viewModels()

    // Chamar o adapter
    private lateinit var adapter: PessoaAdapter

    // Criar o binding
    private var _binding: FragmentAllPessoaBinding? = null
    private val binding: FragmentAllPessoaBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Configurar o  binding
        _binding = FragmentAllPessoaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Quando clicar em algum item da lista
        adapter = PessoaAdapter(viewModel.pessoaList.value){

        }

        //Configura a recycler
        val recycler = binding.rvPessoas
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        // Observar para adicionar um item na lista quando for adicionado
        viewModel.pessoaList.observe(viewLifecycleOwner){
            adapter.updatePessoas(it)
        }
        // Navegar para a tela de cadastro de pessoa
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.pessoaFragment)

            // Carregar as pessoas cadastradas
            viewModel.loadPessoas()
        }
    }
}