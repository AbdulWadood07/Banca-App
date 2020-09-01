package com.stechlabs.banca.models.request

import com.google.gson.annotations.SerializedName

data class CustomerID(

    @SerializedName("customer_id")
    val id:Int
)