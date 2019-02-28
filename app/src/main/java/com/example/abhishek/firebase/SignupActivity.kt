package com.example.abhishek.firebase

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.abhishek.firebase.Retrofit.ApiUtils
import com.example.abhishek.firebase.Retrofit.MyApi
import com.google.gson.Gson
import de.hdodenhof.circleimageview.CircleImageView
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class SignupActivity : AppCompatActivity()
{
    //ALL OBJECT ARE HERE
    private val activity =this@SignupActivity
    private lateinit var img_close: ImageView;
    private lateinit var profile_image: CircleImageView;
    private lateinit var add_ProfileImg: ImageView;
    private lateinit var Edt_signup_firstname: EditText;
    private lateinit var edt_signup_lastname: EditText;
    private lateinit var edt_signup_email: EditText;
    private lateinit var edt_signup_password: EditText;
    private lateinit var edt_signup_birthday: EditText;
    private lateinit var edt_signup_gender:EditText
    private lateinit var txt_signup_create: TextView;
    private lateinit var txt_signup_account: TextView;
    private lateinit var txt_signup_link: TextView;
    private lateinit var input_layout_firstname: TextInputLayout;
    private lateinit var input_layout_lastname: TextInputLayout;
    private lateinit var input_layout_emailsignup: TextInputLayout;
    private lateinit var input_layout_passwordsignup: TextInputLayout;
    private lateinit var input_birthdat: TextInputLayout;
    private lateinit var input_layout_signup_gender:TextInputLayout;
    private lateinit var tv_response :TextView;
    //val pojolist:ArrayList<Pojo> = ArrayList()
    val myCalendar = Calendar.getInstance()
    private lateinit var myApi: MyApi
    private lateinit var mResponseTv: TextView;
    private val TAG = "MyTag"


    //MAIN OVERRIDE FUNCTION
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        myApi = ApiUtils.getAPIService();


        SetUpView();
        OnClick();

    }

    //ALL VIEWS ARE HERE
    private fun SetUpView()
    {
        img_close = findViewById(R.id.img_close) as ImageView;
        profile_image = findViewById(R.id.profile_image) as CircleImageView;
        add_ProfileImg = findViewById(R.id.add_ProfileImg) as ImageView;
        //Edit Text
        Edt_signup_firstname = findViewById(R.id.Edt_signup_firstname) as EditText;
        edt_signup_lastname = findViewById(R.id.edt_signup_lastname) as EditText;
        edt_signup_email = findViewById(R.id.edt_signup_email) as EditText;
        edt_signup_password = findViewById(R.id.edt_signup_password) as EditText;
        edt_signup_birthday = findViewById(R.id.edt_signup_birthday) as EditText;
        edt_signup_gender = findViewById(R.id.edt_signup_gender) as EditText;
        //Textview OnClick
        txt_signup_create = findViewById(R.id.txt_signup_create) as TextView;
        txt_signup_account = findViewById(R.id.txt_signup_account) as TextView;
        txt_signup_link = findViewById(R.id.txt_signup_link) as TextView;
        //TextInputLayout
        input_layout_firstname = findViewById(R.id.input_layout_firstname) as TextInputLayout;
        input_layout_lastname = findViewById(R.id.input_layout_lastname) as TextInputLayout;
        input_layout_emailsignup =findViewById(R.id.input_layout_emailsignup)as TextInputLayout;
        input_layout_passwordsignup=findViewById(R.id.input_layout_passwordsignup) as TextInputLayout;
        input_birthdat =findViewById(R.id.input_birthdat)as TextInputLayout;
        input_layout_signup_gender=findViewById(R.id.input_layout_signup_gender) as TextInputLayout;

        tv_response =findViewById(R.id.tv_response)as TextView;

    }

    //ALL CLICKS ARE HERE
    private fun OnClick()
    {
        txt_signup_create.setOnClickListener(View.OnClickListener
        {
            if (isValid()) {


                var fristname = Edt_signup_firstname.text.toString().trim()
                var lastname = edt_signup_lastname.text.toString().trim()
                var email = edt_signup_email.text.toString().trim()
                var password = edt_signup_password.text.toString().trim()
                var birthday = edt_signup_birthday.text.toString().trim()
                var gender = edt_signup_gender.text.toString().trim()

                sendPost(fristname, lastname ,email,password,birthday,gender);
            }

               /* val intent = Intent(this@SignupActivity,LoginActivity::class.java)
                startActivity(intent);*/

        })

        edt_signup_birthday.setOnClickListener(View.OnClickListener
        {


               val year = myCalendar.get(Calendar.YEAR)
               val month = myCalendar.get(Calendar.MONTH)
               val day = myCalendar.get(Calendar.DAY_OF_MONTH)

               val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                   // Display Selected date in Toast
                   //Toast.makeText(this, """$dayOfMonth - ${monthOfYear + 1} - $year""", Toast.LENGTH_LONG).show()
                   myCalendar.set(Calendar.YEAR, year)
                   myCalendar.set(Calendar.MONTH, monthOfYear)
                   myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                   updateLabel()

               }, year, month, day)
               dpd.show()



        })
        img_close.setOnClickListener(View.OnClickListener
        {
                val intent = Intent(this@SignupActivity,LoginActivity::class.java)
                startActivity(intent);

        })
    }


    //CALENDAR UPDATE FUN
    private fun updateLabel()
    {
        val myFormat = "MM/dd/yy" //In which you need put here
        val sdf = SimpleDateFormat(myFormat, Locale.US)

        edt_signup_birthday.setText(sdf.format(myCalendar.time))
    }


    //SIGNUP DATA POST FUN
    private fun sendPost(fristname: String, lastname: String, email: String, password: String, birthday: String, gender: String)
    {
        //Log.i(TAG,"post API" + f_name);
       // Log.i(TAG,"post API" + f_name + " : " + l_name+ " : " +email+ " : " +password+ " : " +biethday+ " : " +gender);
        val fields = HashMap<String, String>()
        fields.put("firstname", fristname)
        fields.put("lastname", lastname)
        fields.put("email", email)
        fields.put("password", password)
        fields.put("birthday", birthday)
        fields.put("gender", gender)
        val strRequestBody = Gson().toJson(fields)

        var requestBody = RequestBody.create(MediaType.parse("application/json"), strRequestBody)
        Log.e("MYLOG",":   ---  "+strRequestBody.toString());

        myApi.savePost(requestBody).enqueue(object : Callback<Pojo>
        {
            override fun onResponse(call: Call<Pojo>, response: Response<Pojo>)
            {
                Log.i(TAG,"post API" + response.toString());

                if(response.isSuccessful())
                {
//                    showResponse(response.body().toString());
                    Toast.makeText(this@SignupActivity,"complete",Toast.LENGTH_LONG).show();

                    Log.i(TAG, "post submitted to API." + response.body().toString());
                }
            }
            override fun onFailure(call: Call<Pojo>, t: Throwable)
            {
                Toast.makeText(this@SignupActivity,"Error",Toast.LENGTH_LONG).show();
                Log.e(TAG, "Unable to submit post to API."+call.toString() +" :: "+t.toString());
            }


        })

    }

    fun showResponse(response: String) {
        if (mResponseTv!!.getVisibility() === View.GONE) {
            mResponseTv!!.setVisibility(View.VISIBLE)

        }
        mResponseTv!!.setText(response)
    }


    //VALIDATION FUN
    private fun isValid(): Boolean
    {
        input_layout_firstname.setError(null);
        input_layout_lastname.setError(null);
        input_layout_emailsignup.setError(null);
        input_layout_passwordsignup.setError(null);
        input_layout_signup_gender.setError(null);


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
        else if(edt_signup_gender.getText().toString().trim().isEmpty())
        {
            input_layout_signup_gender.setError("Gender is required")
            return false
        }
        else
        {
            return true
        }

    }

}
