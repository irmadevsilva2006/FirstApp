package com.analara.firstapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.analara.firstapp.databinding.ActivityMainBinding
import com.analara.firstapp.databinding.FragmentCalculoBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null

    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

//    var email = binding.edtEmail2.editableText.toString()
//    var telefone = binding.edtTelefone2.editableText.toString()
//
//    if (email.contains("@") && email.contains(".com")) {
//        binding.tvEmail.text = "Email: " + email
//
//    } else {
//        binding.tvEmail.text = "Email inválido: " + email
//    }
//
//    if (telefone.length == 11) {
//        binding.tvTelefone.text = "Telefone válido: " + telefone
//
//    } else {
//        binding.tvTelefone.text = "Telefone inválido: " + telefone
//
//    }
}