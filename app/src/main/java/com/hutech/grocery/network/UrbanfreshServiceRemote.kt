package com.hutech.grocery.network

import androidx.lifecycle.LiveData
import com.hutech.grocery.BASE_URL
import com.hutech.grocery.models.BaseResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query






interface UrbanFreshService {

    @POST("api/home_test_section")
    fun getUrbanFreshCategories(
        @Query("category_id") categoryId:Int
    ): Call<BaseResponse>

    companion object {

        fun create(): UrbanFreshService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UrbanFreshService::class.java)
        }
    }
}