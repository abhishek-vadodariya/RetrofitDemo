package com.example.abhishek.firebase.Retrofit

import com.example.abhishek.firebase.Pojo
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface MyApi
{

    @POST("register")
    //abstract fun createPost(@FieldMap fields: Map<String, String>): Call<Pojo>
    //fun getStringScalar(@Body body: LoginData): Call<Pojo>
    fun savePost(@Body body: RequestBody): Call<Pojo>

    /*fun savePost(@Query("firstname") firstname: String,
                 @Query("lastname") lastname: String,
                 @Query("email") email: String,
                 @Query("password") password: String,
                 @Query("birthday") birthday: String,
                 @Query("gender") gender: String): Call<Pojo>*/
}

