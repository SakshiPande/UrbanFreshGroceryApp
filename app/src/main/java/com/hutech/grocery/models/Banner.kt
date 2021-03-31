package com.hutech.grocery.models

import com.google.gson.annotations.SerializedName

data class Banner (

    @SerializedName("banner_id") val banner_id : Int,
    @SerializedName("banner_name") val banner_name : String,
    @SerializedName("banner_description") val banner_description : String,
    @SerializedName("banner_alt") val banner_alt : String,
    @SerializedName("banner_image") val banner_image : String,
    @SerializedName("url_type") val url_type : String,
    @SerializedName("url_id") val url_id : Int
)