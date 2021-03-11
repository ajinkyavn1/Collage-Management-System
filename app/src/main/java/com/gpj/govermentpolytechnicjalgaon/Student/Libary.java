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

import com.gpj.govermentpolytechnicjalgaon.R;

public class Libary extends Fragment {
    View rootView;
WebView libary;
    public Libary() {
        // Required empty public constructor
    }

    public static Libary newInstance(String param1, String param2) {
        Libary fragment = new Libary();
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
        libary.loadUrl("https://ndl.iitkgp.ac.in");
        WebSettings webSettings=libary.getSettings();
        webSettings.setJavaScriptEnabled(true);
        return rootView;
    }

}
