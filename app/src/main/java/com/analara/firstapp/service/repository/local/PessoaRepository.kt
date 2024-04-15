package com.analara.firstapp.service.repository.local

import android.content.Context
import com.analara.firstapp.service.model.Pessoa

class PessoaRepository(context: Context) {
    private val firstAppDb = FirstAppDataBase.getDataBase(context).pessoaDao()

    suspend fun  insertPessoa(pessoa:Pessoa){
        firstAppDb.insert(pessoa)

    }
    suspend fun getPessoa(id: Int): Pessoa {6
        return firstAppDb.getPessoa(id)
    }

    suspend fun  getPessoas(): List<Pessoa>{
        return firstAppDb.getAll()
    }

    suspend fun updatePessoa(pessoa: Pessoa){
        firstAppDb.update(pessoa)
    }

    suspend fun deletePessoa(id: Int){
        firstAppDb.delete(id)
    }

}