package com.stechlabs.banca.models.request

import com.google.gson.annotations.SerializedName

data class Account(

    @SerializedName("account_type")
    val accountType: AccountType,
    @SerializedName("customer")
    val customer: CustomerID,
    @SerializedName("rate")
    val rate:Double,
    @SerializedName("status")
    val status:String,
    @SerializedName("balance")
    val balance:Double,
    @SerializedName("bank_branch")
    val branch: Branch
)