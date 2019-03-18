package com.example.abhishek.firebase.Object

import com.example.abhishek.firebase.Interface.MyApi

object ApiUtils
{
    fun ApiUtils() {}
    val BASE_URL = "http://192.168.0.65:1235/"


    fun getAPIService(): MyApi {

        return RetrofitClient.getClient(BASE_URL)!!.create(MyApi::class.java)
    }
}