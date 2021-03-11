package com.gpj.govermentpolytechnicjalgaon.Student;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gpj.govermentpolytechnicjalgaon.Comman_Class.PDF;
import com.gpj.govermentpolytechnicjalgaon.Comman_Class.PDFAdapter;
import com.gpj.govermentpolytechnicjalgaon.Constants.Constant;
import com.gpj.govermentpolytechnicjalgaon.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Uploaded_Notes extends Fragment {
    View rootView;
    ProgressDialog progressDialog;

    //an array to hold the different pdf objects
    ArrayList<PDF> pdfList= new ArrayList<PDF>();

    //pdf adapter
    PDFAdapter pdfAdapter;

    //ListView to show the fetched Pdfs from the server
    ListView listView;
    public Uploaded_Notes() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView=inflater.inflate(R.layout.activity_uploaded_notes, container, false);

        listView = (ListView) rootView.findViewById(R.id.listView);

        progressDialog = new ProgressDialog(getContext());

        getPdfs();

        //setting listView on item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                PDF pdf = (PDF) parent.getItemAtPosition(position);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(pdf.getUrl()));
                startActivity(intent);

            }
        });
        return rootView;
    }

    private void getPdfs() {

        progressDialog.setMessage("Fetching Data... Please Wait");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST,  Constant.ip+"/gpj/Departments/IT/Teacher/Syllabus/getPDF.php",

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            Toast.makeText(getContext(),obj.getString("message"), Toast.LENGTH_SHORT).show();

                            JSONArray jsonArray = obj.getJSONArray("pdfs");

                            for(int i=0;i<jsonArray.length();i++){

                                //Declaring a json object corresponding to every pdf object in our json Array
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                //Declaring a Pdf object to add it to the ArrayList  pdfList
                                PDF pdf  = new PDF();
                                String pdfName = jsonObject.getString("name");
                                String pdfUrl = jsonObject.getString("url");
                                pdf.setName(pdfName);
                                pdf.setUrl(pdfUrl);
                                pdfList.add(pdf);

                            }

                            pdfAdapter=new PDFAdapter(getActivity(),R.layout.list_layout, pdfList);

                            listView.setAdapter(pdfAdapter);

                            pdfAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        RequestQueue request = Volley.newRequestQueue(getContext());
        request.add(stringRequest);

    }
    public void onBackPressed() {
        Toast.makeText(getContext(),"hiiii",Toast.LENGTH_LONG).show();

    }
}
