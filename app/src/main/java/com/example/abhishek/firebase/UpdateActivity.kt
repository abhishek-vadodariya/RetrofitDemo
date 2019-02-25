package com.example.abhishek.firebase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UpdateActivity : AppCompatActivity()
{
    private var activity = this@UpdateActivity
    private lateinit var toolbar:Toolbar
    private lateinit var toolbar_back:ImageView
    private lateinit var profile_image_update:CircleImageView
    private lateinit var add_ProfileImg_update:ImageView
    private lateinit var Edt_update_firstname:EditText
    private lateinit var edt_update_lastname:EditText
    private lateinit var edt_update_email :EditText
    private lateinit var edt_update_password :EditText
    private lateinit var edt_update_birthday :EditText
    private lateinit var radioGroup :RadioGroup
    private lateinit var txt_update:TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        SetUpView();
        OnClick();

    }
    private fun SetUpView()
    {
        toolbar=findViewById(R.id.toolbar)
        toolbar_back=findViewById(R.id.toolbar_back)
        profile_image_update=findViewById(R.id.profile_image_update)
        add_ProfileImg_update=findViewById(R.id.add_ProfileImg_update);
        Edt_update_firstname=findViewById(R.id.Edt_update_firstname);
        edt_update_lastname=findViewById(R.id.edt_update_lastname);
        edt_update_email=findViewById(R.id.edt_update_email);
        edt_update_password=findViewById(R.id.edt_update_password);
        edt_update_birthday=findViewById(R.id.edt_update_birthday);
        radioGroup=findViewById(R.id.radioGroup);
        txt_update=findViewById(R.id.txt_update);

    }

    private fun OnClick()
    {
        toolbar_back.setOnClickListener(View.OnClickListener {
            intent= Intent(this@UpdateActivity,ProfileActivity::class.java)
            startActivity(intent)
        })
    }
}
