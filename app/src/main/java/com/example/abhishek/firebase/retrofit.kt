package com.example.abhishek.firebase

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface retrofit
{

    @POST("register")
    fun postData() : Call<List<Pojo>>

}