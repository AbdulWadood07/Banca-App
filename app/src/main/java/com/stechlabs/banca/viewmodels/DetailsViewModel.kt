package com.stechlabs.banca.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.stechlabs.banca.models.responses.Account
import com.stechlabs.banca.models.responses.Employee
import com.stechlabs.banca.models.responses.Transaction
import com.stechlabs.banca.models.responses.TransactionType
import com.stechlabs.banca.repository.Repository

class DetailsViewModel:ViewModel() {


    fun getAccounts(): LiveData<List<Account>> {
        return Repository.getAccounts()
    }


    fun getTransactions():LiveData<List<Transaction>>{
        return Repository.getTransactions()
    }

    fun addTransaction(transaction: com.stechlabs.banca.models.request.Transaction):LiveData<Transaction>{

        return Repository.addTransactions(transaction)
    }


    fun getTransactionType():LiveData<List<TransactionType>>{
        return Repository.getTransactionTypes()
    }

    fun getEmployee():LiveData<List<Employee>>{
        return Repository.getEmployees()
    }
}