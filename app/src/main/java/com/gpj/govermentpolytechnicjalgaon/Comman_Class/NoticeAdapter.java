package com.gpj.govermentpolytechnicjalgaon.Comman_Class;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gpj.govermentpolytechnicjalgaon.R;
import com.gpj.govermentpolytechnicjalgaon.Student.View_Notice;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {

    View_Notice context;
    List<User> data;
    ImageView profilepic;
    TextView username;
    public NoticeAdapter(List<User> data, View_Notice context)
    {
        this.context=context;
        this.data=data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User geter1 =  data.get(position);
        String login,image;
        login=geter1.getLogin();
        image=geter1.getAvatarUrl();

        username.setText(login);
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
            username=(TextView)itemView.findViewById(R.id.Notice_Name);


        }
    }
}

