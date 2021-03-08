package com.gpj.govermentpolytechnicjalgaon.Student;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.gpj.govermentpolytechnicjalgaon.R;

public class Student_Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mnavDrawer;
    TextView name,branch;
    FrameLayout viewNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer_layout_student);
        Toolbar toolbar=findViewById(R.id.Student_Toolbar);
        setSupportActionBar(toolbar);


        toolbar.setTitle("GOVERNMENT POLYTECHNIC JALGAON");

        mnavDrawer=findViewById(R.id.drawer_student);
        NavigationView navigationView=findViewById(R.id.design_navigation_view);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(
                this,mnavDrawer,toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close );
        mnavDrawer.addDrawerListener(toggle);
        toggle.syncState();
        branch=findViewById(R.id.Branch);
        branch.setText("Information Technology");


        switch (Student.Branch)
        {
            case "ME":branch.setText("Mechanical Engineering");;break;
            case "IT":branch.setText("Information Technology"); break;

        }
        viewNotice=findViewById(R.id.View_Notice_Board);
        viewNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Frame,new View_Notice()).commit();

            }
        });
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public void onBackPressed() {
        if(mnavDrawer.isDrawerOpen(GravityCompat.START)){

            mnavDrawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId())
        {
            case R.id.Home:
                startActivity(new Intent(getApplicationContext(),Student_Main.class));
                finish();
                break;
            case R.id.Profile :
                getSupportFragmentManager().beginTransaction()
              .replace(R.id.Frame,new SProfile()).commit();
                   break;
            case R.id.Notice :
                getSupportFragmentManager().beginTransaction()
                .replace(R.id.Frame,new View_Notice()).commit();
                break;

            case R.id.Libary:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.Frame,new Libary()).commit();
                break;

            case R.id.Sessionl_Result:

                break;

            case R.id.Lab:

                break;

            case  R.id.Logout :
                SharedPreferences preferences =getSharedPreferences("user", Context.MODE_PRIVATE);
                preferences.edit().remove("text").commit();
                startActivity(new Intent(getApplicationContext(), Student.class));
                finish();
                break;
        }
        mnavDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
