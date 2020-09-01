package com.stechlabs.banca.models.request

import com.google.gson.annotations.SerializedName

data class JobTitle(

    @SerializedName("job_title_id")
    val id:Int
)