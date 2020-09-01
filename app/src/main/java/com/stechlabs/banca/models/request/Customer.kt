package com.stechlabs.banca.models.request

import com.google.gson.annotations.SerializedName

data class Customer(
    @SerializedName("customer_type")
    val type:String,
    @SerializedName("password")
    val password:String,
    @SerializedName("person")
    val person: Person
)