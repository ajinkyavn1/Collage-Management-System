package com.gpj.govermentpolytechnicjalgaon.Student;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.gpj.govermentpolytechnicjalgaon.Constants.Constant;
import com.gpj.govermentpolytechnicjalgaon.Principal.Saff_info;
import com.gpj.govermentpolytechnicjalgaon.R;

public class Student_Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mnavDrawer;
    TextView name,branch;
    FrameLayout viewNotice,syllabus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer_layout_student);
        View toolbar=findViewById(R.id.Student_Toolbar);
        setSupportActionBar((Toolbar) toolbar);


        ((Toolbar) toolbar).setTitle("GOVERNMENT POLYTECHNIC JALGAON");

        mnavDrawer= (DrawerLayout) findViewById(R.id.drawer_student);
        NavigationView navigationView= (NavigationView) findViewById(R.id.design_navigation_view);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(
                this,mnavDrawer, (Toolbar) toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close );
        mnavDrawer.addDrawerListener(toggle);
        toggle.syncState();
        branch= (TextView) findViewById(R.id.Branch);
        branch.setText("Information Technology");
        switch (Constant.Branch)
        {
            case "ME":branch.setText("Mechanical Engineering");;break;
            case "IT":branch.setText("Information Technology"); break;
            case "CE":branch.setText("Civil Engineering"); break;
            case  "EEE": branch.setText("Electrical Engineering"); break;
            case  "E&tc":branch.setText("E&TC"); break;
            case  "CO":branch.setText("Computer Engineering"); break;
        }
        viewNotice= (FrameLayout) findViewById(R.id.View_Notice_Board);

        viewNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Frame,new View_Notice()).commit();

            }
        });

        findViewById(R.id.Message_To_Staff).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Saff_info.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.Syllabus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Frame,new Uploaded_Notes()).commit();
            }
        });
        findViewById(R.id.Sectinal_Result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Frame,new Result()).commit();
            }
        });


        findViewById(R.id.Activitys).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Frame,new Department_Activity()).commit();
            }
        });

        findViewById(R.id.COMPUTER_LABS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Frame,new Labs()).commit();
            }
        });
        findViewById(R.id.Collage_Activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.Frame,new Collage_Activity()).commit();
            }
        });
        findViewById(R.id.Department_Libary).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.Frame,new Libary()).commit();
            }
        });

        navigationView.setNavigationItemSelectedListener(this);



    }


    @Override
    public void onBackPressed() {
        if(mnavDrawer.isDrawerOpen(GravityCompat.START)){

            mnavDrawer.closeDrawer(GravityCompat.START);
        }else {
            startActivity(new Intent(getApplicationContext(),Student_Main.class));
            finish();
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

            case R.id.Syllabus:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.Frame,new Uploaded_Notes()).commit();
                break;
            case R.id.Collage_Activity:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.Frame,new Collage_Activity()).commit();
                break;
            case R.id.Lab:
                getSupportFragmentManager().beginTransaction()
                .replace(R.id.Frame,new Labs()).commit();
            break;

            case  R.id.Logout :
                startActivity(new Intent(getApplicationContext(), Student.class));
                finish();
                break;
        }
        mnavDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
