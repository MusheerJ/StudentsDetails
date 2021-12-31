package com.oyster.studentsdetails;

public class Student {
    private String studentName;
    private String studentPRN;
    private String studentBranch;
    private String studentClass;

    public Student() {
    }

    public Student(String studentName, String studentPRN, String studentBranch, String studentClass) {
        this.studentName = studentName;
        this.studentPRN = studentPRN;
        this.studentBranch = studentBranch;
        this.studentClass = studentClass;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPRN() {
        return studentPRN;
    }

    public void setStudentPRN(String studentPRN) {
        this.studentPRN = studentPRN;
    }

    public String getStudentBranch() {
        return studentBranch;
    }

    public void setStudentBranch(String studentBranch) {
        this.studentBranch = studentBranch;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
}
