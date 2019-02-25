package com.example.abhishek.firebase

import android.content.Intent
import android.opengl.ETC1.isValid
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.telecom.Call
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.security.auth.callback.Callback
import kotlin.collections.ArrayList

class SignupActivity : AppCompatActivity()
{
    private val activity =this@SignupActivity
    private lateinit var img_close: ImageView;
    private lateinit var profile_image: CircleImageView;
    private lateinit var add_ProfileImg: ImageView;
    private lateinit var Edt_signup_firstname: EditText;
    private lateinit var edt_signup_lastname: EditText;
    private lateinit var edt_signup_email: EditText;
    private lateinit var edt_signup_password: EditText;
    private lateinit var edt_signup_birthday: EditText;
    private lateinit var radioGroup: RadioGroup;
    private lateinit var txt_signup_create: TextView;
    private lateinit var txt_signup_account: TextView;
    private lateinit var txt_signup_link: TextView;
    private lateinit var input_layout_firstname: TextInputLayout;
    private lateinit var input_layout_lastname: TextInputLayout;
    private lateinit var input_layout_emailsignup: TextInputLayout;
    private lateinit var input_layout_passwordsignup: TextInputLayout;
    private lateinit var input_birthdat: TextInputLayout;

    //val myCalendar = Calendar.getInstance()
    private val myCalendar = Calendar.getInstance()

    val pojolist:ArrayList<Pojo> = ArrayList()


    public val url ="http://192.168.0.32:8888/register";

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        SetUpView();
        OnClick();

        /*val date = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, monthOfYear)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel()

        }*/

        /*val datePickerListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, monthOfYear)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "MM/dd/yy"
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            edt_signup_birthday.setText(sdf.format(myCalendar.time))
        }*/
    }
    private fun SetUpView()
    {
        img_close = findViewById(R.id.img_close) as ImageView;
        profile_image = findViewById(R.id.profile_image) as CircleImageView;
        add_ProfileImg = findViewById(R.id.add_ProfileImg) as ImageView;
        Edt_signup_firstname = findViewById(R.id.Edt_signup_firstname) as EditText;
        edt_signup_lastname = findViewById(R.id.edt_signup_lastname) as EditText;
        edt_signup_email = findViewById(R.id.edt_signup_email) as EditText;
        edt_signup_password = findViewById(R.id.edt_signup_password) as EditText;
        edt_signup_birthday = findViewById(R.id.edt_signup_birthday) as EditText;
        radioGroup = findViewById(R.id.radioGroup) as RadioGroup;
        txt_signup_create = findViewById(R.id.txt_signup_create) as TextView;
        txt_signup_account = findViewById(R.id.txt_signup_account) as TextView;
        txt_signup_link = findViewById(R.id.txt_signup_link) as TextView;
        input_layout_firstname = findViewById(R.id.input_layout_firstname) as TextInputLayout;
        input_layout_lastname = findViewById(R.id.input_layout_lastname) as TextInputLayout;
        input_layout_emailsignup =findViewById(R.id.input_layout_emailsignup)as TextInputLayout;
        input_layout_passwordsignup=findViewById(R.id.input_layout_passwordsignup) as TextInputLayout;
        input_birthdat =findViewById(R.id.input_birthdat)as TextInputLayout;

    }

    private fun OnClick()
    {
        txt_signup_create.setOnClickListener(View.OnClickListener
        {
            if (isValid())
            {
                postData();
                val intent = Intent(this@SignupActivity,LoginActivity::class.java)
                startActivity(intent);
            }
        })

        edt_signup_birthday.setOnClickListener(View.OnClickListener
        {

            /* DatePickerDialog(this@SignupActivity, date, myCalendar
                     .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                     myCalendar.get(Calendar.DAY_OF_MONTH)).show()*/
            /* DatePickerDialog(this@SignupActivity, datePickerListener, myCalendar
                     .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                     myCalendar.get(Calendar.DAY_OF_MONTH)).show()*/
        })
        img_close.setOnClickListener(View.OnClickListener
        {
                val intent = Intent(this@SignupActivity,LoginActivity::class.java)
                startActivity(intent);

        })
    }



    fun postData()
    {
        var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()






    }


    /*private fun updateLabel()
    {
        val myFormat = "MM/dd/yy" //In which you need put here
        val sdf = SimpleDateFormat(myFormat, Locale.US)

        edt_signup_birthday.setText(sdf.format(myCalendar.time))
    }*/

    private fun isValid(): Boolean
    {
        input_layout_firstname.setError(null);
        input_layout_lastname.setError(null);
        input_layout_emailsignup.setError(null);
        input_layout_passwordsignup.setError(null);

        if (Edt_signup_firstname.getText().toString().trim().isEmpty())
        {
            input_layout_firstname.setError("First Name is required");
            return false
        }
        else if(edt_signup_lastname.getText().toString().trim().isEmpty())
        {
            input_layout_lastname.setError("Last Name is required");
            return false
        }
        else if(edt_signup_email.getText().toString().trim().isEmpty())
        {
            input_layout_emailsignup.setError("Email is required");
            return false
        }
        else if(edt_signup_password.getText().toString().trim().isEmpty())
        {
            input_layout_passwordsignup.setError("Password is required");
            return false
        }
        else if(edt_signup_birthday.getText().toString().trim().isEmpty())
        {
            input_birthdat.setError("Birthday is required");
            return false
        }
        else
        {
            return true
        }

    }

}
