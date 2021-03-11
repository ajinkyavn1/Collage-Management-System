package com.gpj.govermentpolytechnicjalgaon.Principal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gpj.govermentpolytechnicjalgaon.Constants.Constant;
import com.gpj.govermentpolytechnicjalgaon.R;

public class Principal extends AppCompatActivity implements View.OnClickListener {
    Button login;
    ProgressDialog progressDialog;
    EditText Username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        login= (Button) findViewById(R.id.btnLogin);
        Username= (EditText) findViewById(R.id.etLoginUsername);
        password= (EditText) findViewById(R.id.Password);

        login.setOnClickListener(this);

    }
    @Override
    public void onClick(View V)
    {
        if(V==login)
        {
            String username,pass;
            username=Username.getText().toString().trim();
            pass=password.getText().toString().trim();
            if(username.equals(""))
            {
                Toast.makeText(getApplicationContext(),"Enter The Username ",Toast.LENGTH_SHORT).show();
            }
            else{
                if(pass.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter The Password",Toast.LENGTH_SHORT).show();
                }else {
                    if(username.equals("") && pass.equals(""))
                    {
                        Toast.makeText(this,"Enter The Username and Password",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if(username.equals("admin") && pass.equals("admin"))
                        {
                            startActivity(new Intent(this,Principal_Main.class));
                            Constant.Branch="P";
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Username or Password Incorrect",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }



        }

    }
}
