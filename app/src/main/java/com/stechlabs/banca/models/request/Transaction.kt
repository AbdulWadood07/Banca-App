package com.stechlabs.banca.models.request

import com.google.gson.annotations.SerializedName
import java.util.*

data class Transaction(

    @SerializedName("transaction_date")
    val date: String,
    @SerializedName("debit_credit")
    val debit_credit: String,
    @SerializedName("transaction_type")
    val transactionType: TransactionType,
    @SerializedName("employee")
    val employee: EmployeeID,
    @SerializedName("account")
    val account: AccountID

)