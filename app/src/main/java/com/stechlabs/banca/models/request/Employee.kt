package com.stechlabs.banca.models.request

import com.google.gson.annotations.SerializedName

data class Employee(
    @SerializedName("salary")
    val salary:Double,
    @SerializedName("hourly_rate")
    val rate:Double,
    @SerializedName("password")
    val password:String,
    @SerializedName("person")
    val person: Person,
    @SerializedName("branch")
    val branch: Branch,
    @SerializedName("department")
    val department: Department,
    @SerializedName("job_title")
    val jobTitle: JobTitle
)