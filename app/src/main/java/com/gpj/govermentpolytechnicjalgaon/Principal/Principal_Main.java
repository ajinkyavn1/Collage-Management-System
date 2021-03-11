package com.gpj.govermentpolytechnicjalgaon.Principal;

import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gpj.govermentpolytechnicjalgaon.MainActivity;
import com.gpj.govermentpolytechnicjalgaon.R;
import com.gpj.govermentpolytechnicjalgaon.Student.Collage_Activity;
import com.gpj.govermentpolytechnicjalgaon.Student.Department_Activity;
import com.gpj.govermentpolytechnicjalgaon.Student.Labs;
import com.gpj.govermentpolytechnicjalgaon.Student.Libary;
import com.gpj.govermentpolytechnicjalgaon.Student.Result;
import com.gpj.govermentpolytechnicjalgaon.Student.Student_Main;
import com.gpj.govermentpolytechnicjalgaon.Student.Uploaded_Notes;
import com.gpj.govermentpolytechnicjalgaon.Student.View_Notice;

public class Principal_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_main);

        findViewById(R.id.View_Notice_Board).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.PFRAME,new View_Notice()).commit();
            }
        });

        findViewById(R.id.COMPUTER_LABS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(getApplicationContext(),Lab.class));
            }
        });
        findViewById(R.id.Collage_Activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.PFRAME,new Collage_Activity()).commit();
            }
        });
        findViewById(R.id.Department_Libary).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.PFRAME,new Libary()).commit();
            }
        });
        findViewById(R.id.Message_To_Staff).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

           Intent intent=new Intent(getApplicationContext(),Saff_info.class);
           startActivity(intent);
            }
        });
        findViewById(R.id.Logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {

            startActivity(new Intent(getApplicationContext(), Principal_Main.class));
            finish();
        }

}
