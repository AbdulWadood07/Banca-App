package com.stechlabs.banca.apiService

import androidx.lifecycle.LiveData
import com.stechlabs.banca.models.request.Account
import com.stechlabs.banca.models.responses.*
import com.stechlabs.banca.repository.Repository
import com.stechlabs.banca.models.request.Employee as employee
import com.stechlabs.banca.models.request.Customer as customer
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET(value = "employees/get")
    suspend fun getAllEmployees():Response<List<Employee>>

    @GET(value = "employee/get/{id}")
    suspend fun getEmployeeById(@Path("id") id:Int):Response<Employee>

    @POST(value = "employee/add")
    suspend fun addEmployee(@Body employee:employee):Response<Employee>

    @GET(value = "customers/get")
    suspend fun getAllCustomers():Response<List<Customer>>

    @POST(value = "customer/add")
    suspend fun addCustomer(@Body customer:customer):Response<Customer>

    @GET(value = "customer/get/{id}")
    suspend fun getCustomerById(@Path("id") id:Int):Response<Customer>

    @POST("account/add")
    suspend fun addAccount(@Body account:Account):Response<com.stechlabs.banca.models.responses.Account>

    @GET("accounts/get")
    suspend fun getAccounts():Response<List<com.stechlabs.banca.models.responses.Account>>


    @GET("transaction/get")
    suspend fun getTransactions():Response<List<Transaction>>

    @POST("transaction/add")
    suspend fun addTransaction(@Body transaction:com.stechlabs.banca.models.request.Transaction):Response<Transaction>

    @GET("transaction/type/get")
    suspend fun getTransactionType():Response<List<TransactionType>>

    @GET(value = "types/get")
    suspend fun getAccountTypes():Response<List<AccountType>>

    @GET("departments/get")
    suspend fun getAllDepartments(): Response<List<Department>>

    @GET(value = "branches/get")
    suspend fun getAllBranches():Response<List<Branch>>

    @GET(value = "titles/get")
    suspend fun getAllTiles():Response<List<JobTitle>>

}