package com.dashboard.dojoin.Network

import com.dashboard.dojoin.data.Category
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("Category")
    fun getCategory(): Call<Category?>?
}