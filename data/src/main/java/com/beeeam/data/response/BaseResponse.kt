package com.beeeam.data.response

import com.google.gson.annotations.SerializedName

abstract class BaseResponse (
    @SerializedName("Response") val response: String? = null,
    @SerializedName("Error") val error: String? = null,
)