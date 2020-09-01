package com.stechlabs.banca.models.responses

data class Customer(

    val customer_id:Int,
    val customer_type:String,
    val password:String,
    val person: Person
)