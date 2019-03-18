package com.example.abhishek.firebase.ModelClass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 data class LoginModel(val email:String?, val password:String?)
{
    /*@SerializedName("email")
    @Expose
    private var email: String? = null

    @SerializedName("password")
    @Expose
    private var password: String? = null

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }*/
}