package com.gpj.govermentpolytechnicjalgaon.Student;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.gpj.govermentpolytechnicjalgaon.Comman_Class.NoticeAdapter;
import com.gpj.govermentpolytechnicjalgaon.Constants.Constant;
import com.gpj.govermentpolytechnicjalgaon.R;
import com.gpj.govermentpolytechnicjalgaon.Comman_Class.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class View_Notice extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<User> user;
    String URL_Data= Constant.ip+"/gpj/Departments/IT/Teacher/Notice/IT.php";
    RequestQueue reqQue;
    View rootView;
    public View_Notice() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setRetainInstance(true);
        rootView =inflater.inflate(R.layout.fragment_view_notice, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        recyclerView= (RecyclerView) rootView.findViewById(R.id.recyleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        user=new ArrayList<>();
        switch (Constant.Branch)
        {
            case "ME": URL_Data= Constant.ip+"/gpj/Departments/IT/Teacher/Notice/ME.php";break;
            case "IT":URL_Data= Constant.ip+"/gpj/Departments/IT/Teacher/Notice/IT.php"; break;
            case "CE":URL_Data= Constant.ip+"/gpj/Departments/IT/Teacher/Notice/CE.php";break;
            case  "EEE":URL_Data= Constant.ip+"/gpj/Departments/IT/Teacher/Notice/EEE.php";break;
            case  "E&tc":URL_Data= Constant.ip+"/gpj/Departments/IT/Teacher/Notice/E&TC.php";break;
            case  "CO":URL_Data= Constant.ip+"/gpj/Departments/IT/Teacher/Notice/CO.php";break;
            case  "P":URL_Data= Constant.ip+"/gpj/Departments/IT/Teacher/Notice/p.php";break;
        }

        loadurl();

        return rootView;

    }
    @SuppressLint("NewApi")
    public void loadurl() {
        JsonArrayRequest stringRequest=new JsonArrayRequest(URL_Data, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                getvalue(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        reqQue = Volley.newRequestQueue(getContext());

        reqQue.add(stringRequest);
    }

    public void getvalue(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            User userlist = new User();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);


                userlist.setLogin(json.getString("name"));

                userlist.setAvatarUrl(json.getString("photo"));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            user.add(userlist);
        }

        adapter = new NoticeAdapter(user, this);

        recyclerView.setAdapter(adapter);
    }
}
