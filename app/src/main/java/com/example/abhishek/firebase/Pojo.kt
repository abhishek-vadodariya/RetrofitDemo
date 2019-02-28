package com.example.abhishek.firebase

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Pojo( firstname:String?, lastname:String?,  birthday:String?,  email:String?, password:String?, gender:String?)
{

    //private var firstname: String?=null
    /*private var lastname:String?=null
    private var birthday:String?=null
    private var email:String?=null
    private var password:String?=null
    private var gender :String?=null*/


    @SerializedName("firstname")
    @Expose
    private var firstname: String? = null

    @SerializedName("lastname")
    @Expose
    private var lastname: String? = null

    @SerializedName("email")
    @Expose
    private var email: String? = null

    @SerializedName("birthday")
    @Expose
    private var birthday: String? = null

    @SerializedName("password")
    @Expose
    private var password: String? = null

    @SerializedName("gender")
    @Expose
    private var gender: String? = null


    fun getFirstname(): String? {
        return firstname
    }

    fun setFirstname(firstname: String) {
        this.firstname = firstname
    }

    fun getLastname(): String? {
        return lastname
    }

    fun setLastname(lastname: String) {
        this.lastname = lastname
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun getBirthday(): String? {
        return birthday
    }

    fun setBirthday(birthday: String) {
        this.birthday = birthday
    }

    fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun getGender(): String? {
        return gender
    }

    fun setGender(gender: String) {
        this.gender = gender
    }



    override fun toString(): String
    {
        return "Register{" +
                "firstname='" + firstname +
                ", lastname='" + lastname +
                ", email=" + email +
                ", Birthday=" + birthday +
                ", Password=" + password +
                ", gender=" + gender +
                '}'
    }
}