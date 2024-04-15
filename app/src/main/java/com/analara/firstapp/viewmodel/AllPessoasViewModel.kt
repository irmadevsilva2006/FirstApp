package com.analara.firstapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.analara.firstapp.service.model.Pessoa
import com.analara.firstapp.service.repository.local.PessoaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllPessoasViewModel(application: Application): AndroidViewModel(application) {
    private val repository = PessoaRepository(application)

    private val mPessoaList = MutableLiveData<List<Pessoa>>()
    val pessoaList: LiveData<List<Pessoa>> = mPessoaList

    fun loadPessoas(){
        viewModelScope.launch (Dispatchers.IO){
            mPessoaList.postValue(repository.getPessoas())
        }
    }
}