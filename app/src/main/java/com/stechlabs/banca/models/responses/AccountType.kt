package com.stechlabs.banca.models.responses

import com.google.gson.annotations.SerializedName

data class AccountType(

    @SerializedName("type_id")
    val id:Int,
    @SerializedName("type_name")
    val title:String,
    @SerializedName("description")
    val description:String,
    @SerializedName("rate_range")
    val range:Double
)