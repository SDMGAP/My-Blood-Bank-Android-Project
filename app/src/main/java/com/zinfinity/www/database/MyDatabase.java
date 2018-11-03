package com.zinfinity.www.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.zinfinity.www.model.Donor;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase {


    private SQLiteDatabase sqLiteDatabase;

    public MyDatabase(Context context){
        DBHelper dbHelper = new DBHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
        Log.d("Anik", "MyDataBase Constructor Called");
    }

    public long insertData(String name, int age, String sex, String bloodGroup, String address, String occupation, String phone){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.NAME,name);
        contentValues.put(DBHelper.AGE,age);
        contentValues.put(DBHelper.SEX,sex);
        contentValues.put(DBHelper.BLOOD_GROUP,bloodGroup);
        contentValues.put(DBHelper.ADDRESS,address);
        contentValues.put(DBHelper.OCCUPATION,occupation);
        contentValues.put(DBHelper.PHONE,phone);
        return sqLiteDatabase.insert(DBHelper.TABLE_NEME, null, contentValues);
    }
    public List<Donor> getAllData(){
        String[] column = {DBHelper.UID, DBHelper.NAME,DBHelper.BLOOD_GROUP, DBHelper.PHONE, DBHelper.AGE};
        Cursor cursor = sqLiteDatabase.query(DBHelper.TABLE_NEME,column,null, null, null, null, null);
        List<Donor> returnList = new ArrayList<>();
        while(cursor.moveToNext()){
            int index1 = cursor.getColumnIndex(DBHelper.UID);
            int index2 = cursor.getColumnIndex(DBHelper.NAME);
            int index3 = cursor.getColumnIndex(DBHelper.BLOOD_GROUP);
            int index4 = cursor.getColumnIndex(DBHelper.PHONE);
            int index5 = cursor.getColumnIndex(DBHelper.AGE);
            int id = cursor.getInt(index1);
            String name = cursor.getString(index2);
            String bg = cursor.getString(index3);
            String phone = cursor.getString(index4);
            int age = cursor.getInt(index5);
            returnList.add(new Donor(id, name, bg, phone, age));
        }
        return returnList;
    }

    class DBHelper extends SQLiteOpenHelper{

        private static final String DATABASE_NAME = "donor_info";
        private static final String TABLE_NEME = "DONOR_TABLE";
        private static final int DATABASE_VERSION = 2;
        private static final String UID = "_id";
        private static final String NAME = "name";
        private static final String AGE = "age";
        private static final String SEX = "sex";
        private static final String BLOOD_GROUP = "blood_group";
        private static final String OCCUPATION = "occupation";
        private static final String ADDRESS ="address";
        private static final String PHONE = "phone";
        private static final String
                CREATE_TABLE = "CREATE TABLE "+TABLE_NEME+" ("
                +UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +NAME+" VARCHAR(255), "
                +AGE+" INTEGER NOT NULL, "
                +SEX+" VARCHAR(255), "
                +BLOOD_GROUP+" VARCHAR(255), "
                +OCCUPATION+" VARCHAR(255), "
                +ADDRESS+" VARCHAR(255), "
                +PHONE+" VARCHAR(255));";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NEME;

        private DBHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            Log.d("Anik", "DBHelper Constructor Called");
        }
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            try {
                sqLiteDatabase.execSQL(CREATE_TABLE);
                Log.d("Anik", "onCreate Called");
            } catch (SQLException e) {
                e.printStackTrace();
                Log.d("Anik", ""+e);
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            try {
                sqLiteDatabase.execSQL(DROP_TABLE);
                onCreate(sqLiteDatabase);
                Log.d("Anik", "onUpgrade Called");
            } catch (SQLException e) {
                e.printStackTrace();
                Log.d("Anik", ""+e);
            }
        }
    }
}
