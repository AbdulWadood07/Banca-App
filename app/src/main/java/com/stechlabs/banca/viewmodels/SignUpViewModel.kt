package com.stechlabs.banca.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.stechlabs.banca.models.request.Customer
import com.stechlabs.banca.models.responses.*
import com.stechlabs.banca.repository.Repository

class SignUpViewModel:ViewModel() {

    fun getEmployees():LiveData<List<Employee>>{
        return Repository.getEmployees()
    }

    fun getEmployeeById(id:Int):LiveData<Employee>{
        return Repository.getEmployeeById(id)
    }

    fun addEmployee(employee:com.stechlabs.banca.models.request.Employee):LiveData<Employee>{

       return Repository.addEmployee(employee)
    }

    fun getCustomers():LiveData<List<com.stechlabs.banca.models.responses.Customer>>{
        return Repository.getCustomers()
    }

    fun addCustomer(customer:Customer):LiveData<com.stechlabs.banca.models.responses.Customer>{
        return Repository.addCustomer(customer)
    }

    fun getAccountTypes():LiveData<List<AccountType>>{

        return Repository.getAccountTypes()
    }



    fun addAccount(account:com.stechlabs.banca.models.request.Account):LiveData<Account>{
        return Repository.addAccount(account)
    }



    fun getDepartments():LiveData<List<Department>>{
        return Repository.getDepartments()
    }


    fun getBranches():LiveData<List<Branch>>{
        return Repository.getBranches()
    }

    fun getJobTitles():LiveData<List<JobTitle>>{
        return Repository.getJobTitles()
    }
}