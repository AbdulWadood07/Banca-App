package com.stechlabs.banca.models.responses

import com.google.gson.annotations.SerializedName

data class JobTitle(
    @SerializedName("job_title_id")
    val id:Int,
    @SerializedName("title")
    val title:String,
    @SerializedName("description")
    val description:String
)