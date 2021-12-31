package com.oyster.studentsdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentActivity extends AppCompatActivity {


    EditText studentName;
    EditText studentPrn;
    EditText studentBranch;
    EditText studentClass;
    Button addStudentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        studentBranch = findViewById(R.id.Branch);
        studentPrn = findViewById(R.id.Prn);
        studentClass = findViewById(R.id.Class);
        studentName = findViewById(R.id.Name);
        addStudentBtn = findViewById(R.id.addStudentBtn);

        // for adding students details to database
        addStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Student student = new Student();
                student.setStudentName(studentName.getText().toString());
                student.setStudentPRN(studentPrn.getText().toString());
                student.setStudentClass(studentClass.getText().toString());
                student.setStudentBranch(studentBranch.getText().toString());

                MyDbHandler db = new MyDbHandler(AddStudentActivity.this);

                db.addStudent(student);

                studentName.setText(null);
                studentPrn.setText(null);
                studentClass.setText(null);
                studentBranch.setText(null);
                
                Toast.makeText(AddStudentActivity.this, "Student added", Toast.LENGTH_SHORT).show();


            }
        });


    }
}