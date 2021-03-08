package com.gpj.govermentpolytechnicjalgaon.Student;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.gpj.govermentpolytechnicjalgaon.MySingleton;
import com.gpj.govermentpolytechnicjalgaon.R;

import java.util.HashMap;
import java.util.Map;

public class activity_register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private  EditText username,email,mobail,cpassword,password,enrollment,fullname,rollno,DOB;
    private Button reister,LOGIN;
    ProgressDialog progressDialog;
    String barch;
    String ye;
    String Branch[]={"ME","IT","CE","EEE","E&TC","CO"};
    String Year[]={"FRIST","SECOND","THIRD"};
    String Register="http://192.168.43.196/GPJ/departments/IT/Student//register.php";
    private AlertDialog.Builder builder;
    Spinner s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_registation);
        reister=findViewById(R.id.btnRegister);
        username=findViewById(R.id.etUsername);
        email=findViewById(R.id.Email);
        mobail=findViewById(R.id.MobailNo);
        cpassword=findViewById(R.id.etConfirmPassword);
        password=findViewById(R.id.etPassword);
        enrollment=findViewById(R.id.Enrollment);
        fullname=findViewById(R.id.etFullName);
        rollno=findViewById(R.id.RollNo);
        DOB=findViewById(R.id.DOB);
        LOGIN=findViewById(R.id.btnRegisterLogin);
        final Spinner spin1=findViewById(R.id.spinner);
        progressDialog = new ProgressDialog(this);
        spin1.setOnItemSelectedListener(this);
        ArrayAdapter bran = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Branch);
        bran.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(bran);

        final Spinner spin2=findViewById(R.id.spinner_Year);
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

    private void register()
    {


        final String Username=username.getText().toString().trim();//get The TExt
        final String Email=email.getText().toString().trim();//get The TExt
        final String Mobail=mobail.getText().toString().trim();//get The TExt
        final String Cpassword=cpassword.getText().toString().trim();//get The TExt
        final String  Password=password.getText().toString().trim();//get The TExt
        final String Enrollment=enrollment.getText().toString().trim();//get The TExt
        final String Fullname=fullname.getText().toString().trim();//get The TExt
        final String Rollno=rollno.getText().toString().trim();//get The TExt
        final String dob=DOB.getText().toString().trim();
        username.setText("");
        email.setText("");
        mobail.setText("");
        cpassword.setText("");
        password.setText("");
        enrollment.setText("");
        fullname.setText("");
        rollno.setText("");
        DOB.setText("");
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Register,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("name",Fullname);
                params.put("email",Email);
                params.put("username",Username);
                params.put("password",Password);
                params.put("enrollment",Enrollment);
                params.put("mobail",Mobail);
                params.put("rollno",Rollno);
                params.put("DOB",dob);
                params.put("year",ye);
                params.put("Branch",barch);
                return params;
            }
        };


       MySingleton.getInstance(activity_register.this).addToRequestque(stringRequest);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

