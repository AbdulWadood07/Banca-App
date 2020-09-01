package com.stechlabs.banca.models.responses

import com.google.gson.annotations.SerializedName

data class Branch(
    @SerializedName("branch_id")
    val id:Int,
    @SerializedName("branch_name")
    val name:String,
    @SerializedName("country")
    val country:String,
    @SerializedName("city")
    val city:String,
    @SerializedName("phone")
    val phone:String,
    @SerializedName("bank_name")
    val bank_name:String
)
