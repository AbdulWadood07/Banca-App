package com.stechlabs.banca.repository

import androidx.lifecycle.LiveData
import com.stechlabs.banca.apiService.RetrofitBuilder
import com.stechlabs.banca.models.responses.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main


object Repository {

    fun getEmployees(): LiveData<List<Employee>> {
        val job = Job()
        return object : LiveData<List<Employee>>() {
            override fun onActive() {
                super.onActive()
                job.let {
                    CoroutineScope(IO).launch {
                        val temp = RetrofitBuilder.ApiService.getAllEmployees().body()
                        postValue(temp)
                        job.complete()
                    }
                }
            }
        }
    }

    fun getEmployeeById(id: Int): LiveData<Employee> {
        val job = Job()
        return object : LiveData<Employee>() {
            override fun onActive() {
                super.onActive()
                job.let {
                    CoroutineScope(IO).launch {
                        val temp = RetrofitBuilder.ApiService.getEmployeeById(id).body()
                        postValue(temp)
                        job.complete()
                    }
                }
            }
        }
    }

    fun addEmployee(employee: com.stechlabs.banca.models.request.Employee):LiveData<Employee> {
        val job = Job()
        return object :LiveData<Employee>(){
            override fun onActive() {
                super.onActive()
                job.let {
                    CoroutineScope(IO).launch {
                        val temp = RetrofitBuilder.ApiService.addEmployee(employee).body()
                        postValue(temp)
                        job.complete()
                    }
                }
            }
        }

    }


    fun addCustomer(customer: com.stechlabs.banca.models.request.Customer): LiveData<Customer> {
        val job = Job()
        return object : LiveData<Customer>() {
            override fun onActive() {
                super.onActive()
                job.let {
                    CoroutineScope(IO).launch {
                        val temp = RetrofitBuilder.ApiService.addCustomer(customer).body()
                        postValue(temp)
                        job.complete()
                    }
                }
            }
        }
    }


    fun getCustomerById(id: Int): LiveData<Customer> {
        val job = Job()
        return object : LiveData<Customer>() {
            override fun onActive() {
                super.onActive()
                job.let {
                    CoroutineScope(IO).launch {
                        val temp = RetrofitBuilder.ApiService.getCustomerById(id).body()
                        postValue(temp)
                        job.complete()
                    }
                }
            }
        }
    }


    fun getCustomers(): LiveData<List<Customer>> {
        val job = Job()
        return object : LiveData<List<Customer>>() {
            override fun onActive() {
                super.onActive()
                job.let {
                    CoroutineScope(IO).launch {
                        val temp = RetrofitBuilder.ApiService.getAllCustomers().body()
                        postValue(temp)
                        job.complete()
                    }
                }
            }
        }
    }


    fun getAccountTypes():LiveData<List<AccountType>>{
        val job= Job()
        return object :LiveData<List<AccountType>>(){

            override fun onActive() {
                super.onActive()
                job.let {
                    CoroutineScope(IO).launch {
                        val temp=RetrofitBuilder.ApiService.getAccountTypes().body()
                        postValue(temp)
                        job.complete()
                    }
                }
            }
        }
    }

    fun getAccounts():LiveData<List<Account>>{
        val job= Job()
        return object :LiveData<List<Account>>(){

            override fun onActive() {
                super.onActive()
                job.let {
                    CoroutineScope(IO).launch {
                        val temp=RetrofitBuilder.ApiService.getAccounts().body()
                        postValue(temp)
                        job.complete()
                    }
                }
            }
        }
    }

    fun addAccount(account:com.stechlabs.banca.models.request.Account):LiveData<Account>{
        val job= Job()
        return object :LiveData<Account>(){

            override fun onActive() {
                super.onActive()
                job.let {
                    CoroutineScope(IO).launch {
                        val temp=RetrofitBuilder.ApiService.addAccount(account).body()
                        postValue(temp)
                        job.complete()
                    }
                }
            }
        }
    }


    fun getTransactions(): LiveData<List<Transaction>> {
        val job = Job()
        return object : LiveData<List<Transaction>>() {
            override fun onActive() {
                super.onActive()
                job.let {
                    CoroutineScope(IO).launch {
                        val temp = RetrofitBuilder.ApiService.getTransactions().body()
                        postValue(temp)
                        job.complete()
                    }
                }
            }
        }
    }

    fun addTransactions(transaction:com.stechlabs.banca.models.request.Transaction): LiveData<Transaction> {
        val job = Job()
        return object : LiveData<Transaction>() {
            override fun onActive() {
                super.onActive()
                job.let {
                    CoroutineScope(IO).launch {
                        val temp = RetrofitBuilder.ApiService.addTransaction(transaction).body()
                        postValue(temp)
                        job.complete()
                    }
                }
            }
        }
    }

    fun getTransactionTypes(): LiveData<List<TransactionType>> {
        val job = Job()
        return object : LiveData<List<TransactionType>>() {
            override fun onActive() {
                super.onActive()
                job.let {
                    CoroutineScope(IO).launch {
                        val temp = RetrofitBuilder.ApiService.getTransactionType().body()
                        postValue(temp)
                        job.complete()
                    }
                }
            }
        }
    }
    fun getDepartments(): LiveData<List<Department>> {
        val job = Job()
        return object : LiveData<List<Department>>() {
            override fun onActive() {
                super.onActive()
                job.let {
                    CoroutineScope(IO).launch {
                        val temp = RetrofitBuilder.ApiService.getAllDepartments().body()
                        postValue(temp)
                        job.complete()
                    }
                }
            }
        }
    }


    fun getBranches(): LiveData<List<Branch>> {
        val job = Job()
        return object : LiveData<List<Branch>>() {
            override fun onActive() {
                super.onActive()
                job.let {
                    CoroutineScope(IO).launch {
                        val temp = RetrofitBuilder.ApiService.getAllBranches().body()
                        postValue(temp)
                        job.complete()
                    }
                }
            }
        }
    }


    fun getJobTitles(): LiveData<List<JobTitle>> {
        val job = Job()
        return object : LiveData<List<JobTitle>>() {
            override fun onActive() {
                super.onActive()
                job.let {
                    CoroutineScope(IO).launch {
                        val temp = RetrofitBuilder.ApiService.getAllTiles().body()
                        postValue(temp)
                        job.complete()
                    }
                }
            }
        }
    }
}
