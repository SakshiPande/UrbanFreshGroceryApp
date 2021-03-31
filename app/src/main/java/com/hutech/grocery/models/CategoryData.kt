package com.hutech.grocery.models

import com.google.gson.annotations.SerializedName

data class CategoryData(
    @SerializedName("category_id") val category_id : Int,
    @SerializedName("category_name") val category_name : String,
    @SerializedName("category_description") val category_description : String,
    @SerializedName("category_picture") val category_picture : String
)