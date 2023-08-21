package com.example.student3.controller;

import com.example.student3.model.Student;
import com.example.student3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @GetMapping("/showAllStudents")
    public List<Student> showAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/updateStudent")
    public void updateStudent(@RequestBody Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(updatedStudent.getStudentId());
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setStudentName(updatedStudent.getStudentName());
            existingStudent.setStudentMobileNumber(updatedStudent.getStudentMobileNumber());
            studentRepository.save(existingStudent);
        }
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public void deleteStudentById(@PathVariable("studentId") String studentId) {
        studentRepository.deleteById(Integer.valueOf(studentId));
    }
}
