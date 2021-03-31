package com.hutech.grocery.data

import androidx.lifecycle.LiveData
import com.hutech.grocery.models.BaseResponse

data class RepoResult(
    val data: BaseResponse?,
    val networkErrors: String?
)