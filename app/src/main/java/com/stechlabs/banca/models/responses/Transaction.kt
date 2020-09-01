package com.stechlabs.banca.models.responses

import com.google.gson.annotations.SerializedName

data class Transaction(
    @SerializedName("transaction_id")
    val id:Int,
    @SerializedName("transaction_date")
    val date:String,
    @SerializedName("debit_credit")
    val debit_credit:String,
    @SerializedName("transaction_type")
    val transactionType: TransactionType,
    @SerializedName("employee")
    val employee:Employee,
    @SerializedName("account")
    val account: Account,


)