package com.example.student3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    int studentId;
    String studentName;

    int studentMobileNumber;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentMobileNumber() {
        return studentMobileNumber;
    }

    public void setStudentMobileNumber(int studentMobileNumber) {
        this.studentMobileNumber = studentMobileNumber;
    }


    public Student(int studentId, String studentName, int studentMobileNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentMobileNumber = studentMobileNumber;
    }

    public  Student(){

    }
    public Student(int studentId) {
        this.studentId = studentId;
    }

}
/*
{
  "telugu": 90,
  "hindi": 85,
  "english": 95,
  "maths": 92,
  "science": 88,
  "social": 93,
  "studentId": {
    "studentId": 1
  }
}

 */

