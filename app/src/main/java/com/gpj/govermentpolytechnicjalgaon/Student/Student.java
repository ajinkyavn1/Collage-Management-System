package com.gpj.govermentpolytechnicjalgaon.Student;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.gpj.govermentpolytechnicjalgaon.MySingleton;
import com.gpj.govermentpolytechnicjalgaon.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Student extends AppCompatActivity {
    Button register,login;
    TextView tb;
    ProgressDialog progressDialog;
    static String name, email,DOB,year,Branch,rollNo,mobail,enrollment;
    EditText username,password;
    String url ="http://192.168.43.196/GPJ/departments/IT/Student/Login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        register=findViewById(R.id.btnLoginRegister);
        login=findViewById(R.id.btnLogin);
        tb=findViewById(R.id.tb);
        username=findViewById(R.id.etLoginUsername);
        password=findViewById(R.id.Password);
        SharedPreferences preferences =getSharedPreferences("user", Context.MODE_PRIVATE);
        progressDialog = new ProgressDialog(this);

        preferences.edit().remove("text").commit();
         login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Login();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),activity_register.class));
                finish();
            }
        });

    }

    private void Login() {
        progressDialog.setMessage("Login.... Please Wait..");
        progressDialog.show();
        final String User=username.getText().toString().trim();
        final String Pass=password.getText().toString().trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            JSONObject jsonObject=jsonArray.getJSONObject(0);
                            String status=jsonObject.getString("error");
                            if(status.equals("NO"))
                            {
                                name=jsonObject.getString("name");
                               email=jsonObject.getString("email");
                              DOB =jsonObject.getString("DOB");
                                rollNo =jsonObject.getString("rollNo");
                                 mobail =jsonObject.getString("mobail");
                                 enrollment=jsonObject.getString("enrollment");
                                 Branch =jsonObject.getString("Branch");
                                 year =jsonObject.getString("year");
                                /*SharedPreferences sharedPreferences=getSharedPreferences("user", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                editor.putString("name",name);
                                editor.putString("email",email);
                                editor.putString("DOB",DOB);
                                editor.putString("rollNo",rollNo);
                                editor.putString("mobail",mobail);
                                editor.putString("enrollment",enrollment);
                                editor.putString("Branch",Branch);
                                editor.putString("year",year);
                                editor.apply();*/
                                startActivity(new Intent(getApplicationContext(),Student_Main.class));
                            }
                            else{
                                progressDialog.dismiss();
                                Toast.makeText(getApplicationContext(),"User Not Exits",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", User);
                params.put("password", Pass);
                return params;
            }

            ;
        };
        MySingleton.getInstance(Student.this).addToRequestque(stringRequest);
    }
}