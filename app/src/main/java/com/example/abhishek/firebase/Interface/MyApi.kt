package com.example.abhishek.firebase.Interface

import com.example.abhishek.firebase.ModelClass.LoginModel
import com.example.abhishek.firebase.ModelClass.Pojo
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface MyApi
{
    //@Multipart
    @POST("register")
    //abstract fun createPost(@FieldMap fields: Map<String, String>): Call<Pojo>
    //fun getStringScalar(@Body body: LoginData): Call<Pojo>
    fun savePost(@Body body: RequestBody): Call<Pojo>;

    @POST("login")
    fun login(@Body body_login: RequestBody):Call<LoginModel>

    @GET("getAllUsers")
    fun getData(): Call<Pojo>


}

