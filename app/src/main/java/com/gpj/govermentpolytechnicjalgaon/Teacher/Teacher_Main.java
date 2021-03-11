package com.gpj.govermentpolytechnicjalgaon.Teacher;

import android.content.Intent;
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
import com.gpj.govermentpolytechnicjalgaon.R;
import com.gpj.govermentpolytechnicjalgaon.Student.Collage_Activity;
import com.gpj.govermentpolytechnicjalgaon.Student.Labs;
import com.gpj.govermentpolytechnicjalgaon.Student.Libary;
import com.gpj.govermentpolytechnicjalgaon.Student.Result;
import com.gpj.govermentpolytechnicjalgaon.Student.Uploaded_Notes;
import com.gpj.govermentpolytechnicjalgaon.Student.View_Notice;

public class Teacher_Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private DrawerLayout mnavDrawer;
    TextView name,branch;
    FrameLayout libary,view_notice,addd_notice,upload_study,upload_Department_Acti,CollageActivity,sectinalmarks,Lab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer_layout_teacher);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar_Teacher);
        setSupportActionBar(toolbar);


        mnavDrawer= (DrawerLayout) findViewById(R.id.drawer_student);
        NavigationView navigationView= (NavigationView) findViewById(R.id.design_navigation_view_T);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(
                this,mnavDrawer,toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close );
        mnavDrawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        name= (TextView) findViewById(R.id.HName);
        branch= (TextView) findViewById(R.id.Branch);

        libary= (FrameLayout) findViewById(R.id.Department_Libary);
        view_notice= (FrameLayout) findViewById(R.id.View_Notice_Board);
        addd_notice= (FrameLayout) findViewById(R.id.ADD_Notice);
        upload_study= (FrameLayout) findViewById(R.id.Upload_Syllabus);
        sectinalmarks= (FrameLayout) findViewById(R.id.Result);
        upload_Department_Acti= (FrameLayout) findViewById(R.id.Upload_Dep_Activity);
        CollageActivity = (FrameLayout) findViewById(R.id.Collage_Activity);
        Lab= (FrameLayout) findViewById(R.id.COMPUTER_LABS);

        view_notice.setOnClickListener(this);
        addd_notice.setOnClickListener(this);
        upload_Department_Acti.setOnClickListener(this);
        upload_study.setOnClickListener(this);
        CollageActivity.setOnClickListener(this);
        Lab.setOnClickListener(this);
        sectinalmarks.setOnClickListener(this);
        libary.setOnClickListener(this);


        switch (Constant.Branch)
        {
            case "ME":branch.setText("Mechanical Engineering");;break;
            case "IT":branch.setText("Information Technology"); break;
            case "CE":branch.setText("Civil Engineering"); break;
            case  "EEE": branch.setText("Electrical Engineering"); break;
            case  "E&tc":branch.setText("E&TC"); break;
            case  "CO":branch.setText("Computer Engineering"); break;
        }

    }

    @Override
    public void onBackPressed() {
        if(mnavDrawer.isDrawerOpen(GravityCompat.START)){

            mnavDrawer.closeDrawer(GravityCompat.START);
        }else {
            startActivity(new Intent(getApplicationContext(),Teacher_Main.class));
            finish();
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
            case R.id.Syllabus:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.TFrame,new Uploaded_Notes()).commit();
                  break;
            case R.id.Department_Libary:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.TFrame,new Libary()).commit();
                break;
            case R.id.Activitys:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.Frame,new Upload_Department_activity()).commit(); break;
            case  R.id.Lab :
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.TFrame,new Labs()).commit();break;

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
          case R.id.COMPUTER_LABS:
              getSupportFragmentManager().beginTransaction()
                      .replace(R.id.TFrame,new Labs()).commit();break;
          case R.id.Result:
              getSupportFragmentManager().beginTransaction()
                      .replace(R.id.TFrame,new Sectinol_Marks_Fill()).commit();break;

          case R.id.Department_Libary:
              getSupportFragmentManager().beginTransaction()
                      .replace(R.id.TFrame,new Libary()).commit();
              break;
          case R.id.Collage_Activity:
              getSupportFragmentManager().beginTransaction()
                      .replace(R.id.TFrame,new Collage_Activity()).commit();
          break;


      }
    }
}
