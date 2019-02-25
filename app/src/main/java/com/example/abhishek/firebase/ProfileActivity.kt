package com.example.abhishek.firebase

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.graphics.drawable.Drawable
import android.view.View


class ProfileActivity : AppCompatActivity()
{    private val activity =this@ProfileActivity
     private lateinit var toolbar:Toolbar
     private lateinit var toolbar_update:ImageView
     private lateinit var toolbar_back:ImageView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        SetUpView();
        OnClick();

    }

    private fun SetUpView()
    {
        toolbar = findViewById(R.id.toolbar);
        toolbar_update=findViewById(R.id.toolbar_update);
        toolbar_back=findViewById(R.id.toolbar_back);
    }

   private fun OnClick()
    {
        toolbar_update.setOnClickListener(View.OnClickListener {
            intent = Intent(this@ProfileActivity,UpdateActivity::class.java)
            startActivity(intent)
        })

        toolbar_back.setOnClickListener(View.OnClickListener {
            intent = Intent(this@ProfileActivity,MainActivity::class.java)
            startActivity(intent)
        })


    }



}
