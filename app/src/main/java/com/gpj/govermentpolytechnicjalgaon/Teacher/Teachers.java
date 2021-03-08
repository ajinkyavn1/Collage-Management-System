package com.gpj.govermentpolytechnicjalgaon.Teacher;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class Teachers extends AppCompatActivity {
    Button register,login;
    TextView tb;
    ProgressDialog progressDialog;
    EditText username,password;
     static  String name,Branch,DOB,yearoj,email,mobail;
    String url ="http://192.168.43.196/GPJ/Departments/IT/Teacher/Login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);
        register=findViewById(R.id.btnLoginRegister);
        login=findViewById(R.id.btnLogin);
        tb=findViewById(R.id.tb);
        username=findViewById(R.id.etLoginUsername);
        password=findViewById(R.id.Password);
        progressDialog = new ProgressDialog(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            
                Login();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Teacher_Register.class));
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
                                yearoj =jsonObject.getString("Year_of_joining");
                               DOB =jsonObject.getString("DOB");
                               Branch =jsonObject.getString("Branch");
                                 mobail =jsonObject.getString("Mobail");
                                startActivity(new Intent(getApplicationContext(), Teacher_Main.class));
                                progressDialog.dismiss();

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
        MySingleton.getInstance(Teachers.this).addToRequestque(stringRequest);
    }
}