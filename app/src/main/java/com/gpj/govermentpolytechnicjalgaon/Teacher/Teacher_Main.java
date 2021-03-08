package com.gpj.govermentpolytechnicjalgaon.Teacher;

import android.content.Intent;
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
import com.gpj.govermentpolytechnicjalgaon.Student.Libary;
import com.gpj.govermentpolytechnicjalgaon.Student.View_Notice;

public class Teacher_Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private DrawerLayout mnavDrawer;
    TextView name,branch;
    FrameLayout libary,view_notice,addd_notice,upload_study,upload_Department_Acti,takeattendane,sectinalmarks,Lab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer_layout_teacher);
        Toolbar toolbar=findViewById(R.id.toolbar_Teacher);
        setSupportActionBar(toolbar);


        mnavDrawer=findViewById(R.id.drawer_student);
        NavigationView navigationView=findViewById(R.id.design_navigation_view_T);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(
                this,mnavDrawer,toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close );
        mnavDrawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        name=findViewById(R.id.HName);
        branch=findViewById(R.id.Branch);

        libary=findViewById(R.id.Department_Libary);
        view_notice=findViewById(R.id.View_Notice_Board);
        addd_notice=findViewById(R.id.ADD_Notice);
        upload_study=findViewById(R.id.Upload_Syllabus);
        sectinalmarks=findViewById(R.id.Result);
        upload_Department_Acti=findViewById(R.id.Upload_Dep_Activity);
        takeattendane=findViewById(R.id.Take_Attendance);
        Lab=findViewById(R.id.COMPUTER_LABS);

        view_notice.setOnClickListener(this);
        addd_notice.setOnClickListener(this);
        upload_Department_Acti.setOnClickListener(this);
        upload_study.setOnClickListener(this);
        takeattendane.setOnClickListener(this);
        Lab.setOnClickListener(this);
        sectinalmarks.setOnClickListener(this);
        libary.setOnClickListener(this);


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
            case R.id.Profile :
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.TFrame,new TProfile()).commit();
                break;
            case R.id.Notice :
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.TFrame,new View_Notice()).commit();
                break;

            case R.id.ADDNotice:

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.TFrame,new Upload_Notice()).commit();
                break;

            case R.id.Upload_Dep_activity:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.TFrame,new Upload_Department_activity()).commit();
                break;

            case R.id.Result:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.TFrame,new Sectinol_Marks_Fill()).commit();
                  break;
            case R.id.Department_Libary:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.TFrame,new Libary()).commit();
                break;

            case  R.id.Logout :

                startActivity(new Intent(getApplicationContext(), Teachers.class));
                finish();
                break;
        }
        mnavDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
      switch (id)
      {
          case R.id.View_Notice_Board:
              getSupportFragmentManager().beginTransaction()
                  .replace(R.id.TFrame,new View_Notice()).commit();
              break;
          case R.id.ADD_Notice:
              getSupportFragmentManager().beginTransaction()
                      .replace(R.id.TFrame,new Upload_Notice()).commit();
              break;

          case R.id.Upload_Dep_Activity:
              getSupportFragmentManager().beginTransaction()
                      .replace(R.id.TFrame,new Upload_Department_activity()).commit();
              break;
          case R.id.Upload_Syllabus:
              getSupportFragmentManager().beginTransaction()
                      .replace(R.id.TFrame,new Study_Material_Upload()).commit();
              break;
          case R.id.COMPUTER_LABS:  break;
          case R.id.Result:
              getSupportFragmentManager().beginTransaction()
                      .replace(R.id.TFrame,new Sectinol_Marks_Fill()).commit();
              break;

          case R.id.Department_Libary:
              getSupportFragmentManager().beginTransaction()
                      .replace(R.id.TFrame,new Libary()).commit();
              break;
          case R.id.Take_Attendance: break;
      }
    }
}
