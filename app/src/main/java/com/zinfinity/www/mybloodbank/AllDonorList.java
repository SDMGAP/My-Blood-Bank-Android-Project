package com.zinfinity.www.mybloodbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.zinfinity.www.Adapter.MyBaseAdapter;
import com.zinfinity.www.database.DataBaseManipulation;
import com.zinfinity.www.model.Donor;

import java.util.ArrayList;
import java.util.List;

public class AllDonorList extends AppCompatActivity {

    private int REQUEST_CODE=1;
    DataBaseManipulation dataBaseManipulation;
    ListView donor_list;
    MyBaseAdapter myBaseAdapter;
    List<Donor> donorList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_donor_list);
        dataBaseManipulation = new DataBaseManipulation(this);
        donor_list = findViewById(R.id.donor_list);
        donorList = new ArrayList<>();
        donorList = dataBaseManipulation.getAllDonarList();
        if(donorList.isEmpty()){
            Toast.makeText(this, "List is Empty", Toast.LENGTH_LONG).show();
        }
        myBaseAdapter = new MyBaseAdapter(this, donorList);
        donor_list.setAdapter(myBaseAdapter);
        donor_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_donor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.addUser){
            Intent intent = new Intent(AllDonorList.this, GetDonorInformation.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        donorList = dataBaseManipulation.getAllDonarList();
        myBaseAdapter = new MyBaseAdapter(this, donorList);
        donor_list.setAdapter(myBaseAdapter);
        myBaseAdapter.notifyDataSetChanged();
        Log.d("Anik", "called");
        super.onResume();
    }
}
