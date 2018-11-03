package com.zinfinity.www.mybloodbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.zinfinity.www.Adapter.MyBaseAdapter;
import com.zinfinity.www.database.DataBaseManipulation;

public class GetDonorInformation extends AppCompatActivity {

    EditText name, age, sex, blood_group, occupation, division, distric, upozila, phone;
    DataBaseManipulation dataBaseManipulation;
    MyBaseAdapter myBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_info);
        initialize();
    }

    public void initialize(){
        name = findViewById(R.id.nameInput);
        age = findViewById(R.id.ageInput);
        sex = findViewById(R.id.sexInput);
        blood_group = findViewById(R.id.bloodGroupInput);
        occupation = findViewById(R.id.occupationInput);
        division = findViewById(R.id.divisionInput);
        distric = findViewById(R.id.districInput);
        upozila = findViewById(R.id.upozilaInput);
        phone = findViewById(R.id.phnNoInput);
        dataBaseManipulation = new DataBaseManipulation(this);
    }

    public void addDonor(){
        String mName = name.getText().toString();
        int mAge = Integer.parseInt(age.getText().toString());
        String mSex = sex.getText().toString();
        String mBloodGroup = blood_group.getText().toString();
        String mOccupation = occupation.getText().toString();
        String mDivision = division.getText().toString();
        String mDistrict = distric.getText().toString();
        String mUpozila = upozila.getText().toString();
        String mPhone = phone.getText().toString();
        String mAddress = mUpozila+" "+mDistrict+" "+mDivision;
        dataBaseManipulation.addNewDonor(mName,mAge,mSex,mBloodGroup,mAddress,mOccupation,mPhone);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.donor_detail_submit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.submit){
            addDonor();
            Toast.makeText(this, "Data Saved Successfully",Toast.LENGTH_LONG).show();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
