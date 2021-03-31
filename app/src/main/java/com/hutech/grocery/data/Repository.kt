package com.hutech.grocery.data

import androidx.lifecycle.MutableLiveData
import com.hutech.grocery.models.BaseResponse
import com.hutech.grocery.network.UrbanFreshService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository ( private  val service: UrbanFreshService){


    fun getCategories():MutableLiveData<BaseResponse> {

        val baseResponseLiveData=MutableLiveData<BaseResponse>()

        service.getUrbanFreshCategories(2).enqueue( object : Callback<BaseResponse> {
            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.success) {
                            val baseResponse = response.body()
                            baseResponseLiveData.value=baseResponse
                        }
                    }

                }
            }
        })
        return baseResponseLiveData
    }






    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(service: UrbanFreshService) =
            instance ?: synchronized(this) {
                instance
                    ?: Repository(
                        service
                    ).also { instance = it }
            }

    }
}