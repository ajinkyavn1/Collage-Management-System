package com.gpj.govermentpolytechnicjalgaon;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {

    private static MySingleton mInstanse;
    private RequestQueue requestQueue;
    private static  Context mCtx;


    public MySingleton(Context context) {
        mCtx=context;
        requestQueue=getRequestQueue();
    }

    public RequestQueue getRequestQueue()
    {
        if(requestQueue==null)
        {
            requestQueue= Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized  MySingleton getInstance(Context context)
    {
        if(mInstanse==null)
        {
            mInstanse=new MySingleton(context);
        }
        return  mInstanse;
    }

    public <T> void  addToRequestque(Request<T> request)
    {
        requestQueue.add(request);
    }
}
