package com.stechlabs.banca.models.request

import com.google.gson.annotations.SerializedName

data class Branch(
 @SerializedName("branch_id")
 val id:Int
)