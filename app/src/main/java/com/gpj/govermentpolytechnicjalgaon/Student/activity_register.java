package com.gpj.govermentpolytechnicjalgaon.Student;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class activity_register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private  EditText username,email,mobail,cpassword,password,enrollment,fullname,rollno,DOB;
    private Button reister,LOGIN;
    ProgressDialog progressDialog;
    String barch;
    String ye;
    Calendar c;
    DatePicker datePicker;
    String Branch[]={"ME","IT","CE","EEE","E&TC","CO"};
    String Year[]={"FRIST","SECOND","THIRD"};
    String Register= Constant.ip+"/GPJ/Departments/IT/Student//register.php";
    private AlertDialog.Builder builder;
    Spinner s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_registation);
        reister= (Button) findViewById(R.id.btnRegister);
        username= (EditText) findViewById(R.id.etUsername);
        email= (EditText) findViewById(R.id.Email);
        mobail= (EditText) findViewById(R.id.MobailNo);
        cpassword= (EditText) findViewById(R.id.etConfirmPassword);
        password= (EditText) findViewById(R.id.etPassword);
        enrollment= (EditText) findViewById(R.id.Enrollment);
        fullname= (EditText) findViewById(R.id.etFullName);
        rollno= (EditText) findViewById(R.id.RollNo);
        DOB= (EditText) findViewById(R.id.DOB);
        LOGIN= (Button) findViewById(R.id.btnRegisterLogin);
        final Spinner spin1= (Spinner) findViewById(R.id.spinner);
        progressDialog = new ProgressDialog(this);
        spin1.setOnItemSelectedListener(this);
        ArrayAdapter bran = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Branch);
        bran.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(bran);

        final Spinner spin2= (Spinner) findViewById(R.id.spinner_Year);
        spin2.setOnItemSelectedListener(this);
        ArrayAdapter yea = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Year);
        yea.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(yea);

        reister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                progressDialog.setMessage("Registering.... Please Wait..");
                progressDialog.show();
                 barch=spin1.getSelectedItem().toString();
               ye=spin2.getSelectedItem().toString();
                register();
            }
        });
        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(getApplicationContext(),Student.class));
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
        final String Enrollment = enrollment.getText().toString().trim();//get The TExt
        final String Fullname = fullname.getText().toString().trim();//get The TExt
        final String Rollno = rollno.getText().toString().trim();//get The TExt
        final String dob = DOB.getText().toString().trim();
        username.setText("");
        email.setText("");
        mobail.setText("");
        cpassword.setText("");
        password.setText("");
        enrollment.setText("");
        fullname.setText("");
        rollno.setText("");
        DOB.setText("");
        if (!Cpassword.equals(password)) {
            Toast.makeText(getApplicationContext(), "Password Does not match",Toast.LENGTH_LONG).show();

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
                    params.put("enrollment", Enrollment);
                    params.put("mobail", Mobail);
                    params.put("rollno", Rollno);
                    params.put("DOB", dob);
                    params.put("year", ye);
                    params.put("Branch", barch);
                    return params;
                }
            };


            MySingleton.getInstance(activity_register.this).addToRequestque(stringRequest);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

