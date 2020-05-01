package com.example.datapassintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Show_Details extends AppCompatActivity {

    private static final String TAG = "Show_Details ";
    TextView tvName, tvAge, tvClassName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__details);

        findViewByid();


//        getDataFromIntent();
//        getDatafromBundle();


        getDataFromParceable();

    }

    private void findViewByid() {
        tvAge = findViewById(R.id.D_Age);
        tvName = findViewById(R.id.D_Name);
        tvClassName = findViewById(R.id.D_Class);

    }

    private void getDataFromParceable() {
        //collect our intent
        Intent intent = getIntent();
        StudentParceable student = intent.getParcelableExtra("Deta");
        String name = student.getName();
        Integer age = student.getAge();
        String className = student.getClassName();

        tvName.setText(name);
        tvAge.setText(String.valueOf(age));
        tvClassName.setText(String.valueOf(className));

        Log.v(TAG, name);
    }

    private void getDataFromIntent() {
        Intent i = getIntent();
        String name = i.getStringExtra("Name");
        Integer age = i.getIntExtra("Age", 1);
        String className = i.getStringExtra("ClassName");
        tvName.setText(name);
        tvClassName.setText(className);
        tvAge.setText(String.valueOf(age));
    }

    private void getDatafromBundle() {
        Intent i = getIntent();
        Bundle b = i.getBundleExtra("student");
        String name = b.getString("Name");
        Integer age = b.getInt("Age");
        String className = b.getString("ClassName");
        tvName.setText(name);
        tvClassName.setText(className);
        tvAge.setText(String.valueOf(age));
    }
}