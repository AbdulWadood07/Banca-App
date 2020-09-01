package com.stechlabs.banca.models.request

import com.google.gson.annotations.SerializedName

data class TransactionType(

    @SerializedName("transaction_type_id")
    val id:Int,
)