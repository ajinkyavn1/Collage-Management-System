package com.gpj.govermentpolytechnicjalgaon.Student;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.gpj.govermentpolytechnicjalgaon.Constants.Constant;
import com.gpj.govermentpolytechnicjalgaon.R;

public class SProfile extends Fragment {
View rootView;
    TextView NAME,EMAIL,MOBAIL,ENROLLMENT,YEAR,DOB,ROLL,BRANCH;
    public SProfile() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setRetainInstance(true);
        rootView = inflater.inflate(R.layout.fragment_sprofile, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        NAME= (TextView) rootView.findViewById(R.id.Name);
        EMAIL= (TextView) rootView.findViewById(R.id.Email);
        ENROLLMENT= (TextView) rootView.findViewById(R.id.Enrollment);
        MOBAIL= (TextView) rootView.findViewById(R.id.Mobail);
        YEAR= (TextView) rootView.findViewById(R.id.Year);
        DOB= (TextView) rootView.findViewById(R.id.DOB);
        ROLL= (TextView) rootView.findViewById(R.id.Roll);
        BRANCH= (TextView) rootView.findViewById(R.id.Branch);

        NAME.append(Student.name);
        EMAIL.append(Student.email);
        ENROLLMENT.append(Student.enrollment);
        MOBAIL.append(Student.mobail);
        YEAR.append(Student.year);
        DOB.append(Student.DOB);
        ROLL.append(Student.rollNo);
        BRANCH.append(Constant.Branch);


        return rootView;
    }

}
