package com.analara.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.analara.firstapp.R
import com.analara.firstapp.databinding.FragmentCalculoBinding
import java.time.LocalDateTime

class CalculoFragment : Fragment() {

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
            var nome = binding.edtNome.editableText.toString()
            binding.tvNome.text = "Nome: " + nome

            var AnoNascimento = binding.edtAnoNascimento.editableText.toString()
            var anoAtual = LocalDateTime.now().year
            var idade = 2024 - AnoNascimento.toInt()

            binding.tvidade.text = "Idade: ${idade}"
        }
    }

}