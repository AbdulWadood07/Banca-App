package com.stechlabs.banca.models.request

import com.google.gson.annotations.SerializedName


data class Person(

    @SerializedName("fname")
    val fname:String,
    @SerializedName("lname")
    val lname:String,
    @SerializedName("age")
    val age:Int,
    @SerializedName("address")
    val address: String,
    @SerializedName("email_address")
    val email:String,
    @SerializedName("phone_number")
    val phone_no:String,
    @SerializedName("mobile_number")
    val mobile_no:String
)
