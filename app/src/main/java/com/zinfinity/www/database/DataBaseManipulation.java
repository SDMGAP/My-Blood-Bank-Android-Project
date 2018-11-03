package com.zinfinity.www.database;

import android.content.Context;
import android.util.Log;

import com.zinfinity.www.model.Donor;

import java.util.List;

public class DataBaseManipulation {

    private MyDatabase myDatabase;
    public DataBaseManipulation(Context context){
        myDatabase = new MyDatabase(context);
    }

    public void addNewDonor(String name, int age, String sex, String bloodGroup, String address, String occupation, String phone){
        long id = myDatabase.insertData(name,age,sex,bloodGroup,address,occupation, phone);
        if(id>0){
            Log.d("Anik", "Data Inserted");
        }
        else{
            Log.d("Anik", "Error Occurred");
        }
    }
    public List<Donor> getAllDonarList(){
        List<Donor> returnList;
        returnList = myDatabase.getAllData();
        return returnList;
    }
}
