package com.gpj.govermentpolytechnicjalgaon.Principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.gpj.govermentpolytechnicjalgaon.Constants.Constant;
import com.gpj.govermentpolytechnicjalgaon.R;
import com.gpj.govermentpolytechnicjalgaon.Student.Labs;

public class Saff_info extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner sp;
    WebView wb;
    String Branch[] = {"E&TC","ME", "IT", "CE", "EEE", "CO"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saff_info);
        sp = (Spinner) findViewById(R.id.spinner2);
        final ArrayAdapter adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, Branch);
        sp.setAdapter(adapter);
        wb= (WebView) findViewById(R.id.web);
        wb.setWebViewClient(new WebViewClient());
        WebSettings webSettings=wb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        sp.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String lab=adapterView.getSelectedItem().toString();
        if(lab=="ME")
        {

            wb.loadUrl(Constant.ip+"/GPJ/Departments/IT/Teacher/Staff%20info/ME.html");


        }
        if(lab=="IT")
        {
            wb.loadUrl(Constant.ip+"/GPJ/Departments/IT/Teacher/Staff%20info/IT.html");
        }
        if(lab=="CE")
        {
            wb.loadUrl(Constant.ip+"/GPJ/Departments/IT/Teacher/Staff%20info/CE.html");
        } if(lab=="EEE")
        { wb.loadUrl(Constant.ip+"/GPJ/Departments/IT/Teacher/Staff%20info/EEE.html");
        }
        if(lab=="E&TC")
        {
            wb.loadUrl(Constant.ip+"/GPJ/Departments/IT/Teacher/Staff%20info/EEE.html");
        }
        if(lab=="CO")
        {
            wb.loadUrl(Constant.ip+"/GPJ/Departments/IT/Teacher/Staff%20info/CO.html");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
