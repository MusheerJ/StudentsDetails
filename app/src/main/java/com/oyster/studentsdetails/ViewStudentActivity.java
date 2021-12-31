package com.oyster.studentsdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewStudentActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);


        textView = findViewById(R.id.studentView);

        MyDbHandler db = new MyDbHandler(ViewStudentActivity.this);
//        db.deleteRecords();
        ArrayList<Student> students = (ArrayList<Student>) db.getStudentDetails();


        for (Student student : students) {
            String s = textView.getText().toString();
            textView.setText(s + "\n" + student.getStudentName() + "\t" + student.getStudentPRN() + "\t" + student.getStudentBranch() + "\t" + student.getStudentClass() + "\n");

        }
    }
}