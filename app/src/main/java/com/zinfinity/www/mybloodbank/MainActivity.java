package com.zinfinity.www.mybloodbank;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mName, mPassword;
    private CheckBox mCheckBox;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    final String pass = "12345", name = "Anik";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = findViewById(R.id.userId);
        mPassword = findViewById(R.id.loginPassword);
        Button btnLogin = findViewById(R.id.buttonLogin);
        mCheckBox = findViewById(R.id.checkBox);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();

        checkedSharedPreferrence();

        final Intent intent = new Intent(this, AllDonorList.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCheckBox.isChecked()){
                    editor.putString(getString(R.string.checkbox), "True");
                    editor.apply();

                    String name = mName.getText().toString();
                    editor.putString(getString(R.string.name), name);
                    editor.commit();

                    String password = mPassword.getText().toString();
                    editor.putString(getString(R.string.password), password);
                    editor.commit();
                }
                else {
                    editor.putString(getString(R.string.checkbox), "False");
                    editor.commit();

                    editor.putString(getString(R.string.name), "");
                    editor.commit();

                    editor.putString(getString(R.string.password), "");
                    editor.commit();
                }
                if(mName.getText().toString().equals(name) && mPassword.getText().toString().equals(pass)){
                    Toast.makeText(MainActivity.this, "LogIn Successful", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "UserName or Password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void checkedSharedPreferrence(){
        String checkbox = sharedPreferences.getString(getString(R.string.checkbox),"false");
        String name = sharedPreferences.getString(getString(R.string.name),"");
        String password = sharedPreferences.getString(getString(R.string.password),"");

        mName.setText(name);
        mPassword.setText(password);

        if(checkbox.equals("True")){
            mCheckBox.setChecked(true);
        }
        else{
            mCheckBox.setChecked(false);
        }

    }
}

