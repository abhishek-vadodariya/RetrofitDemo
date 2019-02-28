package com.example.abhishek.firebase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v7.widget.AppCompatEditText
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class LoginActivity : AppCompatActivity()
{
    private val activity =this@LoginActivity;
    private lateinit var edt_login_email: AppCompatEditText;
    private lateinit var edt_login_password: AppCompatEditText;
    private lateinit var txt_forgotpassword: TextView;
    private lateinit var txt_login_signin: TextView;
    private lateinit var txt_login_signup_account: TextView;
    private lateinit var txt_login_signup_link: TextView;
    private lateinit var img_login_facebook_login: ImageView;
    private lateinit var img_google_login: ImageView;
    private lateinit var input_layout_email: TextInputLayout;
    private lateinit var input_layout_password: TextInputLayout;



    public val url = "http://192.168.0.32:8080/login"

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        SetUpView();
        OnClick();
    }

    private fun SetUpView()
    {
        edt_login_email =findViewById(R.id.edt_login_email) as AppCompatEditText;
        edt_login_password =findViewById(R.id.edt_login_password) as AppCompatEditText;
        txt_forgotpassword =findViewById(R.id.txt_forgotpassword) as TextView;
        txt_login_signin = findViewById(R.id.txt_login_signin) as TextView;
        txt_login_signup_account =findViewById(R.id.txt_login_signup_account) as TextView;
        txt_login_signup_link = findViewById(R.id.txt_login_signup_link) as TextView;
        img_login_facebook_login =findViewById(R.id.img_login_facebook_login) as ImageView;
        img_google_login =findViewById(R.id.img_google_login) as ImageView;
        input_layout_email =findViewById(R.id.input_layout_email)as TextInputLayout;
        input_layout_password=findViewById(R.id.input_layout_password) as TextInputLayout;

    }

    private fun OnClick()
    {
        txt_login_signin.setOnClickListener(View.OnClickListener
        {
            if(isValid())
            {
                val intent = Intent(this@LoginActivity,MainActivity::class.java)
                startActivity(intent);
            }

        })

        txt_login_signup_link.setOnClickListener(View.OnClickListener {

            val intent = Intent(this@LoginActivity,SignupActivity::class.java);
            startActivity(intent);
        })

    }

    private fun isValid(): Boolean {

        input_layout_email.setError(null);
        input_layout_password.setError(null);

        if (edt_login_email.getText().toString().trim().isEmpty())
        {
            input_layout_email.setError("Email is required");
            return false
        }
        else if(edt_login_password.getText().toString().trim().isEmpty())
        {
            input_layout_password.setError("Email is required");
            //input_layout_password.error=null;
            return false
        }
        else
        {
            return true
        }

    }
}
