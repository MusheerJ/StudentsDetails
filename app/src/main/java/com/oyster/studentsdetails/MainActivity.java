package com.oyster.studentsdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // onclick listner for going to add student activity
        findViewById(R.id.AddStudent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //for going to add student activity
                startActivity(new Intent(MainActivity.this, AddStudentActivity.class));
            }
        });

        findViewById(R.id.ViewStudents).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //for going to add student activity
                startActivity(new Intent(MainActivity.this,ViewStudentActivity.class));
            }
        });


    }
}