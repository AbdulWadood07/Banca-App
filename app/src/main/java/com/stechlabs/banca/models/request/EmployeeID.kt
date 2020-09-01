package com.stechlabs.banca.models.request

import com.google.gson.annotations.SerializedName

data class EmployeeID(
    @SerializedName("employee_id")
    val id:Int
)