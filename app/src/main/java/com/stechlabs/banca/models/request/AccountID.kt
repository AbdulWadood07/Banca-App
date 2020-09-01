package com.stechlabs.banca.models.request

import com.google.gson.annotations.SerializedName

data class AccountID (

    @SerializedName("account_id")
    val id:Int
)
