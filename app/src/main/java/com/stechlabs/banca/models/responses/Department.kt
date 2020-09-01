package com.stechlabs.banca.models.responses

import com.google.gson.annotations.SerializedName

data class Department(

    @SerializedName("department_id")
    var id:Int,
    @SerializedName("department_name")
    var name:String,
    @SerializedName("hod")
    var hod:String)