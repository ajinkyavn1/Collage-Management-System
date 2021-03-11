package com.gpj.govermentpolytechnicjalgaon.Teacher;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.gpj.govermentpolytechnicjalgaon.Comman_Class.MySingleton;
import com.gpj.govermentpolytechnicjalgaon.Constants.Constant;
import com.gpj.govermentpolytechnicjalgaon.R;

import java.util.HashMap;
import java.util.Map;

public class Teacher_Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText username,email,mobail,cpassword,password,YOJ,fullname,Ocupation,DOB;
    private Button reister,LOGIN;
    String barch;
    ProgressDialog progressDialog;
    String Branch[]={"ME","IT","CE","EEE","E&TC","CO"};
    String Register= Constant.ip+"/GPJ/Departments/IT/Teacher/register.php";

    private AlertDialog.Builder builder;
    Spinner s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__register);
        progressDialog = new ProgressDialog(this);
        reister= (Button) findViewById(R.id.btnRegister);
        username= (EditText) findViewById(R.id.etUsername);
        email= (EditText) findViewById(R.id.Email);
        mobail= (EditText) findViewById(R.id.MobailNo);
        cpassword= (EditText) findViewById(R.id.etConfirmPassword);
        password= (EditText) findViewById(R.id.etPassword);
        YOJ= (EditText) findViewById(R.id.YOJ);
        fullname= (EditText) findViewById(R.id.etFullName);
        Ocupation= (EditText) findViewById(R.id.Ocupation);

        DOB= (EditText) findViewById(R.id.DOB);
        LOGIN= (Button) findViewById(R.id.btnRegisterLogin);
        final Spinner spin1= (Spinner) findViewById(R.id.spinner);
        spin1.setOnItemSelectedListener(this);
        ArrayAdapter bran = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Branch);
        bran.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(bran);


        reister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                barch=spin1.getSelectedItem().toString();
                progressDialog.setMessage("Registering.... Please Wait..");
                progressDialog.show();
                register();
            }
        });
        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(getApplicationContext(), Teachers.class));
                finish();
            }
        });

    }

    private void register() {

        final String Username = username.getText().toString().trim();//get The TExt
        final String Email = email.getText().toString().trim();//get The TExt
        final String Mobail = mobail.getText().toString().trim();//get The TExt
        final String Cpassword = cpassword.getText().toString().trim();//get The TExt
        final String Password = password.getText().toString().trim();//get The TExt
        final String yoj = YOJ.getText().toString().trim();//get The TExt
        final String Fullname = fullname.getText().toString().trim();//get The TExt
        final String ocupation = Ocupation.getText().toString().trim();//get The TExt
        final String dob = DOB.getText().toString().trim();
        username.setText("");
        email.setText("");
        mobail.setText("");
        cpassword.setText("");
        password.setText("");
        YOJ.setText("");
        fullname.setText("");
        Ocupation.setText("");
        DOB.setText("");
        if (!Cpassword.equals(password)) {
            Toast.makeText(getApplicationContext(), "Password Does not match", Toast.LENGTH_LONG).show();

        } else {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Register,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();


                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("name", Fullname);
                    params.put("email", Email);
                    params.put("username", Username);
                    params.put("password", Password);
                    params.put("ocupation", ocupation);
                    params.put("mobail", Mobail);
                    params.put("Year_of_joining", yoj);
                    params.put("DOB", dob);
                    params.put("Branch", barch);
                    return params;
                }
            };


            MySingleton.getInstance(Teacher_Register.this).addToRequestque(stringRequest);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

