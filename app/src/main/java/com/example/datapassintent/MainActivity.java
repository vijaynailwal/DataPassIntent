package com.example.datapassintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, age, className;
    Button button;
    StudentParceable student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewByid();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                sendDataIntent();
//                sendDataBundle();
                sendDataParceable();


            }
        });
    }

    private void findViewByid() {
        name = findViewById(R.id.Ed_Name);
        age = findViewById(R.id.Ed_Age);
        className = findViewById(R.id.Ed_Class);
        button = findViewById(R.id.E_btn);

    }

    private void sendDataParceable() {
        int agee = Integer.parseInt(age.getText().toString());
        String classNames = className.getText().toString();
        student = new StudentParceable(agee, name.getText().toString(), classNames);
        Intent intent = new Intent(MainActivity.this, Show_Details.class);
        intent.putExtra("Deta", student);
        startActivity(intent);
    }

    private void sendDataBundle() {
        Intent I = new Intent(MainActivity.this, Show_Details.class);
        Bundle b = new Bundle();
        int x = Integer.parseInt(age.getText().toString());
        String y = className.getText().toString();
        b.putString("Name", name.getText().toString());
        b.putInt("Age", x);
        b.putString("ClassName", y);
        I.putExtra("student", b);
        startActivity(I);

    }

    private void sendDataIntent() {
        Intent I = new Intent(MainActivity.this, Show_Details.class);
        int x = Integer.parseInt(age.getText().toString());
        I.putExtra("Name", name.getText().toString());
        I.putExtra("Age", x);
        I.putExtra("ClassName", className.getText().toString());
        startActivity(I);

    }
}