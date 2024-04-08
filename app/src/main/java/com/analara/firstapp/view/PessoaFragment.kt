package com.analara.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.analara.firstapp.databinding.FragmentCalculoBinding
import com.analara.firstapp.service.model.Pessoa
import com.analara.firstapp.viewmodel.PessoaViewModel
import java.time.LocalDateTime

class PessoaFragment : Fragment() {
    private val viewModel: PessoaViewModel by viewModels()

    private var _binding: FragmentCalculoBinding? = null

    private val binding: FragmentCalculoBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEnviar.setOnClickListener {
            val nome = binding.edtNome.editableText.toString()
            var AnoNascimento = binding.edtAnoNascimento.editableText.toString()
            if (nome != "" && AnoNascimento != ""){
                binding.tvNome.text = "Nome: " + nome


                var anoAtual = LocalDateTime.now().year
                var idade = 2024 - AnoNascimento.toInt()

                binding.tvidade.text = "Idade: ${idade}"

                val pessoa = Pessoa(
                    nome = nome,
                    idade = idade
                )

                viewModel.insert(pessoa)
                binding.edtNome.editableText.clear()
                binding.edtAnoNascimento.editableText.clear()
            }else{
                Toast.makeText(requireContext(),"digite os dados", Toast.LENGTH_LONG).show()
            }

        }
    }

}