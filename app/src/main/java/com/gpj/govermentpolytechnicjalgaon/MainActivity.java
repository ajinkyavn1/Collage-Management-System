package com.gpj.govermentpolytechnicjalgaon;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gpj.govermentpolytechnicjalgaon.Principal.Principal;
import com.gpj.govermentpolytechnicjalgaon.Teacher.Teachers;

public class MainActivity extends AppCompatActivity {

    private static int Time=2000;
    View Student;
    View Teacher,pr;
    public static boolean student=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spash_s);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                setContentView(R.layout.activity_main);

                Student=findViewById(R.id.Student);
                Teacher=findViewById(R.id.Teacher);
                pr=findViewById(R.id.PR);
                Student.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getApplicationContext(), com.gpj.govermentpolytechnicjalgaon.Student.Student.class));

                    }
                });
                Teacher.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getApplicationContext(), Teachers.class));

                    }
                });
                pr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        startActivity(new Intent(getApplicationContext(), com.gpj.govermentpolytechnicjalgaon.Principal.Principal.class));
                    }
                });
            }
        },Time);



    }
}
