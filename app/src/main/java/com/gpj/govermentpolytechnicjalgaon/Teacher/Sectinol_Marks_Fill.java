package com.gpj.govermentpolytechnicjalgaon.Teacher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gpj.govermentpolytechnicjalgaon.Constants.Constant;
import com.gpj.govermentpolytechnicjalgaon.R;
import com.gpj.govermentpolytechnicjalgaon.Student.Libary;


public class Sectinol_Marks_Fill extends Fragment {

    View rootView;
    WebView libary;
    public Sectinol_Marks_Fill() {
        // Required empty public constructor
    }

    public static Sectinol_Marks_Fill newInstance(String param1, String param2) {
        Sectinol_Marks_Fill  fragment = new Sectinol_Marks_Fill();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setRetainInstance(true);
        rootView =inflater.inflate(R.layout.fragment_libary, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        libary=(WebView) rootView.findViewById(R.id.Libary_Webview);
        libary.setWebViewClient(new WebViewClient());
        libary.loadUrl( Constant.ip+"/srms/");
        WebSettings webSettings=libary.getSettings();
        webSettings.setJavaScriptEnabled(true);
        return rootView;
    }

}