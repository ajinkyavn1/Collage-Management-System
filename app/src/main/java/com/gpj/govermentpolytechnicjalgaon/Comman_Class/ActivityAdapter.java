package com.gpj.govermentpolytechnicjalgaon.Comman_Class;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gpj.govermentpolytechnicjalgaon.R;
import com.gpj.govermentpolytechnicjalgaon.Student.Department_Activity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ViewHolder> {

    Department_Activity context;
    List<User> data;
    ImageView profilepic;
    TextView username;
    TextView name;
    public ActivityAdapter(List<User> data, Department_Activity context)
    {
        this.context=context;
        this.data=data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity__list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User geter1 =  data.get(position);
        String user,login,image;
        login=geter1.getLogin();
        image=geter1.getAvatarUrl();
        user=geter1.getName();
        username.append(user);
        name.setText(login);
        Picasso.get().load(image).fit().into(profilepic);



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);

            profilepic=(ImageView)itemView.findViewById(R.id.profilepic);
            name=(TextView)itemView.findViewById(R.id.notice_Name);
            username= (TextView) itemView.findViewById(R.id.Username);

        }
    }
}

