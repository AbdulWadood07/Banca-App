package com.stechlabs.banca.models.responses

import com.google.gson.annotations.SerializedName

data class TransactionType(

    @SerializedName("transaction_type_id")
    val id:Int,
    @SerializedName("transaction_name")
    val name:String,
    @SerializedName("description")
    val description:String
)