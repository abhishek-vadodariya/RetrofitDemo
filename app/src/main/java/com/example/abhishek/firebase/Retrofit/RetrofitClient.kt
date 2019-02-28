package com.example.abhishek.firebase.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient
{
    //val BASE_URL = "http://192.168.0.32:8888"
    //private var mInstance: RetrofitClient? = null
    var retrofit: Retrofit? = null


     fun getClient(BASE_URL: String): Retrofit?
     {
         if (retrofit == null)
         {
             retrofit = Retrofit.Builder()
                     .baseUrl(BASE_URL)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build()
         }
         return retrofit
     }

}