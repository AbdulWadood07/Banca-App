package com.stechlabs.banca.models.responses

data class Person(

    val person_id:Int,
    val fname:String,
    val lname:String,
    val age:Int,
    val address:String,
    val email_address:String,
    val phone_number:String,
    val mobile_number:String
)
