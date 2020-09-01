package com.stechlabs.banca.models.request

import com.google.gson.annotations.SerializedName

data class AccountType(
    @SerializedName("type_id")
    val id:Int
)