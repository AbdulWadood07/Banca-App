package com.stechlabs.banca.models.request

import com.google.gson.annotations.SerializedName

data class Department(
    @SerializedName("department_id")
    val id: Int
)