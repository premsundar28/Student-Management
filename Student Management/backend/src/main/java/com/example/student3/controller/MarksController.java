package com.example.student3.controller;

import com.example.student3.model.Marks;
import com.example.student3.model.Student;
import com.example.student3.repository.MarksRepository;
import com.example.student3.repository.StudentRepository;
import com.example.student3.service.StudentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class MarksController {
    @Autowired
    MarksRepository marksRepository;
    @Autowired
    StudentRepository studentRepository;
    @PostMapping("/addMarks")
    public void addMarks(@RequestBody Marks marks){
        marksRepository.save(marks);
    }

    @GetMapping("/getStudentMarks/{id}")
    public List<Marks> getStudentMarks(@PathVariable("id") int id) {
        return marksRepository.getStudentMarks(id);
    }

    @PostMapping("/updateMarks/{studentId}")
    public void updateMarksByStudentId(@PathVariable("studentId") int studentId, @RequestBody Marks updatedMarks) {
        // Check if the student with the given ID exists in the database
        if (marksRepository.existsById(studentId)) {
            // Retrieve the existing marks for the student from the database
            Marks existingMarks = marksRepository.getById(studentId);

            // Update the existing marks with the new values
            existingMarks.setTelugu(updatedMarks.getTelugu());
            existingMarks.setHindi(updatedMarks.getHindi());
            existingMarks.setEnglish(updatedMarks.getEnglish());
            existingMarks.setMaths(updatedMarks.getMaths());
            existingMarks.setScience(updatedMarks.getScience());
            existingMarks.setSocial(updatedMarks.getSocial());

            // Save the updated marks in the database
            marksRepository.save(existingMarks);
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
        }
    }
    @PostMapping("/getStudentGrade")
    public String getStudentGrade(@RequestBody StudentQuery studentQuery) {
        String grade = "";

        // Check if studentId is provided
        if (studentQuery.getStudentId() != null) {
            int studentId = studentQuery.getStudentId();
            Optional<Student> optionalStudent = studentRepository.findById(studentId);
            if (optionalStudent.isPresent()) {
                Student student = optionalStudent.get();
                Optional<Marks> optionalMarks = marksRepository.findByStudentId_StudentId(studentId);
                if (optionalMarks.isPresent()) {
                    Marks marks = optionalMarks.get();
                    grade = calculateGrade(marks);
                }
            }
        }

        // Check if studentName is provided
        if (studentQuery.getStudentName() != null) {
            String studentName = studentQuery.getStudentName();
            Optional<Student> optionalStudent = studentRepository.findByStudentName(studentName);
            if (optionalStudent.isPresent()) {
                Student student = optionalStudent.get();
                if (studentQuery.getStudentId() == null) {
                    Optional<Marks> optionalMarks = marksRepository.findByStudentId_StudentId(student.getStudentId());
                    if (optionalMarks.isPresent()) {
                        Marks marks = optionalMarks.get();
                        grade = calculateGrade(marks);
                    }
                }
            }
        }

        return grade;
    }

    private String calculateGrade(Marks marks) {
        int totalMarks = marks.getTelugu() + marks.getHindi() + marks.getEnglish() + marks.getMaths() + marks.getScience() + marks.getSocial();
        int averageMarks = totalMarks / 6;

        if (averageMarks >= 90) {
            return "A+";
        } else if (averageMarks >= 80) {
            return "A";
        } else if (averageMarks >= 70) {
            return "B";
        } else if (averageMarks >= 60) {
            return "C";
        } else if (averageMarks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }


}
