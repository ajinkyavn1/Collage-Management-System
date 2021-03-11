package com.gpj.govermentpolytechnicjalgaon.Teacher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.gpj.govermentpolytechnicjalgaon.Constants.Constant;
import com.gpj.govermentpolytechnicjalgaon.R;


public class TProfile extends Fragment {
    View rootView;
    TextView NAME,EMAIL,MOBAIL,Joining,DOB,ROLL,BRANCH;
    public TProfile() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setRetainInstance(true);
        rootView = inflater.inflate(R.layout.tprofile, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        NAME = (TextView) rootView.findViewById(R.id.Name);
        EMAIL = (TextView) rootView.findViewById(R.id.Email);
        MOBAIL = (TextView) rootView.findViewById(R.id.Mobail);
       Joining = (TextView) rootView.findViewById(R.id.Join_Year);
        DOB = (TextView) rootView.findViewById(R.id.DOB);
        BRANCH = (TextView) rootView.findViewById(R.id.Branch);


        NAME.append(Teachers.name);
        EMAIL.append(Teachers.email);
        DOB.append(Teachers.DOB);
        MOBAIL.append(Teachers.mobail);
        Joining.append(Teachers.yearoj);
        BRANCH.append(Constant.Branch);

        return rootView;
    }


}
