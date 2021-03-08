package com.gpj.govermentpolytechnicjalgaon.Teacher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

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
        NAME = rootView.findViewById(R.id.Name);
        EMAIL = rootView.findViewById(R.id.Email);
        MOBAIL = rootView.findViewById(R.id.Mobail);
       Joining = rootView.findViewById(R.id.Join_Year);
        DOB = rootView.findViewById(R.id.DOB);
        BRANCH = rootView.findViewById(R.id.Branch);


        NAME.append(Teachers.name);
        EMAIL.append(Teachers.email);
        DOB.append(Teachers.DOB);
        MOBAIL.append(Teachers.mobail);
        Joining.append(Teachers.yearoj);
        BRANCH.append(Teachers.Branch);

        return rootView;
    }


}
