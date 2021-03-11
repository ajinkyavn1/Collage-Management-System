package com.gpj.govermentpolytechnicjalgaon.Student;

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


public class Result extends Fragment {
    View rootView;
    WebView libary;
    public Result() {
        // Required empty public constructor
    }

    public static Result newInstance(String param1, String param2) {
        Result fragment = new Result();
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
        libary.loadUrl( Constant.ip+"/srms/find-result.php");
        WebSettings webSettings=libary.getSettings();
        webSettings.setJavaScriptEnabled(true);
        return rootView;
    }

}

