package com.oyster.studentsdetails;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "studentdb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "studenttb";

    // below variable is for our STUDENT_NAME column.
    private static final String STUDENT_NAME = "student_name";

    // below variable is for our STUDENT_PRN column
    private static final String STUDENT_PRN = "student_prn";

    // below variable is for our STUDENT_BRANCH column.
    private static final String STUDENT_BRANCH = "student_branch";

    // below variable for our STUDENT_CLASS column.
    private static final String STUDENT_CLASS = "student_class";

    MyDbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + STUDENT_NAME + " TEXT,"
                + STUDENT_PRN + " TEXT,"
                + STUDENT_BRANCH + " TEXT,"
                + STUDENT_CLASS + " TEXT)";
        try {

            sqLiteDatabase.execSQL(query);
            Log.d("Success", "onCreate: " + "table created");
        } catch (Exception e) {
            Log.d("Execption", "onCreate: " + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addStudent(Student student) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        values.put(STUDENT_NAME, student.getStudentName());
        values.put(STUDENT_PRN, student.getStudentPRN());
        values.put(STUDENT_BRANCH, student.getStudentBranch());
        values.put(STUDENT_CLASS, student.getStudentClass());

        // after adding all values we are passing
        // content values to our table.
        try {

            db.insert(TABLE_NAME, null, values);
            Log.d("Success", "addStudent: " + "added");
        } catch (Exception e) {
            Log.d("falied", "addStudent: " + e.getMessage());
        }

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public List<Student> getStudentDetails() {
        List<Student> students = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorStudents = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.

        // moving our cursor to first position.

//        String query = "CREATE TABLE " + TABLE_NAME + " ("
//                + STUDENT_NAME + " TEXT,"
//                + STUDENT_PRN + " TEXT,"
//                + STUDENT_BRANCH + " TEXT,"
//                + STUDENT_CLASS + " TEXT)";
        if (cursorStudents.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.

                Student student = new Student();
                student.setStudentName(cursorStudents.getString(0));
                student.setStudentPRN(cursorStudents.getString(1));
                student.setStudentBranch(cursorStudents.getString(2));
                student.setStudentClass(cursorStudents.getString(3));
                students.add(student);
            } while (cursorStudents.moveToNext());


        }
        return students;

    }


    void deleteRecords() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);

    }


}