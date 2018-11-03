package com.zinfinity.www.Adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.zinfinity.www.model.Donor;
import com.zinfinity.www.mybloodbank.MainActivity;
import com.zinfinity.www.mybloodbank.R;

import java.util.List;

public class MyBaseAdapter extends BaseAdapter{

    private Context context;
    private List<Donor> donorList;

    public MyBaseAdapter(Context context, List<Donor> donorList){
        this.context = context;
        this.setItems(donorList);
    }

    @Override
    public int getCount() {
        return (getItems()!=null && !getItems().isEmpty())?getItems().size():0;
    }

    @Override
    public Object getItem(int i) {
        return (getItems() != null && !getItems().isEmpty()) ? getItems().get(i) : null ;
    }

    @Override
    public long getItemId(int i) {
        return (getItems() != null && !getItems().isEmpty()) ? getItems().get(i).getmId() : i;
    }

    class MyViewHolder{
        TextView mBgGroup, mName, mPhone, mAge;
        ImageButton call;
        public MyViewHolder(View view){
            mBgGroup = view.findViewById(R.id.bgGroup_single_row);
            mName = view.findViewById(R.id.name_single_row);
            mPhone = view.findViewById(R.id.phone_single_row);
            mAge = view.findViewById(R.id.age_singleRow);
            call = view.findViewById(R.id.action_call);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Currently we are working on it!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public View getView(int i, View v, ViewGroup viewGroup) {
        View view= v;
        MyViewHolder holder;
        if(view == null){
            view = View.inflate(context, R.layout.single_row_design,null);
            holder = new MyViewHolder(view);
            view.setTag(holder);
        }
        else{
            holder = new MyViewHolder(view);
        }
        String BGroup = donorList.get(i).getBloodGroup();
        String Donor_Name = donorList.get(i).getName();
        String Phone = donorList.get(i).getContactNo();
        int Age = donorList.get(i).getAge();
        holder.mBgGroup.setText(BGroup);
        holder.mName.setText(Donor_Name);
        holder.mPhone.setText(Phone);
        holder.mAge.setText("Age: "+Age);
        return view;
    }


    public List<Donor> getItems(){
        return donorList;
    }
    public void setItems(List<Donor> donorList){
        this.donorList = donorList;
    }
}

