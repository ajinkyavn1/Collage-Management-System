package com.gpj.govermentpolytechnicjalgaon.Student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.gpj.govermentpolytechnicjalgaon.NoticeAdapter;
import com.gpj.govermentpolytechnicjalgaon.R;
import com.gpj.govermentpolytechnicjalgaon.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class View_Notice extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<User> user;
    String URL_Data="http://192.168.43.196/gpj/Departments/IT/Teacher/Notice/Q.php";
    RequestQueue reqQue;
    View rootView;
    public View_Notice() {
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
        rootView =inflater.inflate(R.layout.fragment_view_notice, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        recyclerView=rootView.findViewById(R.id.recyleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        user=new ArrayList<>();

        loadurl();

        return rootView;

    }
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
