package com.example.abhishek.firebase.Object

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import com.google.gson.Gson




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