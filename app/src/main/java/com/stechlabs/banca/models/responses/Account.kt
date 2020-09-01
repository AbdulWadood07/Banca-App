package com.stechlabs.banca.models.responses

import com.google.gson.annotations.SerializedName

data class Account(

    @SerializedName("account_id")
    val id:Int,
    @SerializedName("account_type")
    val accountType: AccountType,
    @SerializedName("customer")
    val customer:Customer,
    @SerializedName("rate")
    val rate:Double,
    @SerializedName("status")
    val status:String,
    @SerializedName("balance")
    val balance:Double,
    @SerializedName("bank_branch")
    val branch:Branch
)