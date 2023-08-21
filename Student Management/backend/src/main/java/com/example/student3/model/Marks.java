package com.example.student3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "marks_table")
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "marks_id")
    int marksId;

    @Column(name = "telugu")
    int telugu;

    @Column(name = "hindi")
    int hindi;

    @Column(name = "english")
    int english;

    @Column(name = "maths")
    int maths;

    @Column(name = "science")
    int science;

    @Column(name = "social")
    int social;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student studentId;

    public Marks(int telugu, int hindi, int english, int maths, int science, int social, Student studentId) {
        this.telugu = telugu;
        this.hindi = hindi;
        this.english = english;
        this.maths = maths;
        this.science = science;
        this.social = social;
        this.studentId = studentId;
    }

    public int getMarksid() {
        return marksId;
    }

    public void setMarksid(int marksid) {
        this.marksId = marksid;
    }

    public int getTelugu() {
        return telugu;
    }

    public void setTelugu(int telugu) {
        this.telugu = telugu;
    }

    public int getHindi() {
        return hindi;
    }

    public void setHindi(int hindi) {
        this.hindi = hindi;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMaths() {
        return maths;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }
    public Marks(){

    }
    /*
    {
  "studentId": 123,
  "studentName": "John Doe",
  "studentMobileNumber": 1234567890
}

     */

}

