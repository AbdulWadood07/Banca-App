package com.stechlabs.banca.models.responses

import com.google.gson.annotations.SerializedName

data class Employee(

    @SerializedName("employee_id")
    val id:Int,
    @SerializedName("salary")
    val salary:Double,
    @SerializedName("hourly_rate")
    val hourly_rate:Double,
    @SerializedName("password")
    val password:String,
    @SerializedName("person")
    val person: Person,
    @SerializedName("branch")
    val branch: Branch,
    @SerializedName("department")
    val department: Department,
    @SerializedName("job_title")
    val jobTitle: JobTitle,
)