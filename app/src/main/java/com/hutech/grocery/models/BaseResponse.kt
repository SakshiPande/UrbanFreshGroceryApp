package com.hutech.grocery.models

import com.google.gson.annotations.SerializedName

data class BaseResponse (@SerializedName("success") val success : Boolean,
                         @SerializedName("components") val components : List<Components>)