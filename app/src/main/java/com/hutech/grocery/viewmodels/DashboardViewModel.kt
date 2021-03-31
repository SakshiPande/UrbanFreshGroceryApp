package com.hutech.grocery.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hutech.grocery.data.Repository
import com.hutech.grocery.models.Banner
import com.hutech.grocery.models.BaseResponse
import com.hutech.grocery.models.CategoryData

class DashboardViewModel(private val repository: Repository) :ViewModel() {

    private var baseResponse:LiveData<BaseResponse> = repository.getCategories()




    fun getCategories():LiveData<BaseResponse> {
        return this.baseResponse



    }
}
