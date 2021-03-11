package com.gpj.govermentpolytechnicjalgaon.Student;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.gpj.govermentpolytechnicjalgaon.Constants.Constant;
import com.gpj.govermentpolytechnicjalgaon.R;


public class Labs extends Fragment {

    public Labs() {
        // Required empty public constructor
    }
View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView=inflater.inflate(R.layout.it_lab, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        switch (Constant.Branch)
        {
            case "ME": rootView= inflater.inflate(R.layout.me_lab, container, false);break;
            case "IT": rootView= inflater.inflate(R.layout.it_lab, container, false);; break;
            case "CE" :rootView=inflater.inflate(R.layout.ce_lab, container, false);break;
            case  "EEE":  rootView=inflater.inflate(R.layout.eee_lab, container, false);break;
            case  "E&TC":rootView= inflater.inflate(R.layout.etc_lab, container, false);break;
            case  "CO":  rootView=inflater.inflate(R.layout.co_lab, container, false);break;
        }

        return rootView;

    }
}
