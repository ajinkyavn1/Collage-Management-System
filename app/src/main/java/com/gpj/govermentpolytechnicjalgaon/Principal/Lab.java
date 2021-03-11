package com.gpj.govermentpolytechnicjalgaon.Principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.gpj.govermentpolytechnicjalgaon.Constants.Constant;
import com.gpj.govermentpolytechnicjalgaon.R;
import com.gpj.govermentpolytechnicjalgaon.Student.Labs;

public class Lab extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner sp;
    String Branch[] = {"E&TC","ME", "IT", "CE", "EEE", "CO"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac);
        sp = (Spinner) findViewById(R.id.spinner2);
       final ArrayAdapter adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, Branch);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String lab=adapterView.getSelectedItem().toString();
        if(lab=="ME")
        {
            Constant.Branch="ME";
            getSupportFragmentManager().beginTransaction().replace(R.id.PFRAME,new Labs()).commit();

        }
        if(lab=="IT")
        {
            Constant.Branch="IT";
            getSupportFragmentManager().beginTransaction().replace(R.id.PFRAME,new Labs()).commit();
        }
        if(lab=="CE")
        {
            Constant.Branch="CE";
            getSupportFragmentManager().beginTransaction().replace(R.id.PFRAME,new Labs()).commit();

        } if(lab=="EEE")
        {
            Constant.Branch="EEE";
            getSupportFragmentManager().beginTransaction().replace(R.id.PFRAME,new Labs()).commit();
        }
        if(lab=="E&TC")
        {
            Constant.Branch="E&TC";
            getSupportFragmentManager().beginTransaction().replace(R.id.PFRAME,new Labs()).commit();
        }
        if(lab=="CO")
        {
            Constant.Branch="CO";
            getSupportFragmentManager().beginTransaction().replace(R.id.PFRAME,new Labs()).commit();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
