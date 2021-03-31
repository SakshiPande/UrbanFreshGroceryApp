package com.hutech.grocery.models

import com.google.gson.annotations.SerializedName

data class Components (

    @SerializedName("name") val name : String,
    @SerializedName("StaticBanner") val staticBanner : List<Banner>,
    @SerializedName("AdsBanner") val adsBanner:List<Banner>,
    @SerializedName("categorydata") val categoryData:List<CategoryData>

)