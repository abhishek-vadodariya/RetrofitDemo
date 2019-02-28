package com.example.abhishek.firebase.Retrofit

object ApiUtils
{
    fun ApiUtils() {}
    val BASE_URL = "http://192.168.0.32:8888/"


    fun getAPIService(): MyApi {

        return RetrofitClient.getClient(BASE_URL)!!.create(MyApi::class.java)
    }
}