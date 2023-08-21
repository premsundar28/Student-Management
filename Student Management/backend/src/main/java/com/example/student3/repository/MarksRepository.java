package com.example.student3.repository;

import com.example.student3.model.Marks;
import com.example.student3.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MarksRepository extends JpaRepository<Marks,Integer> {
    @Query(value = "SELECT * FROM marks_table WHERE student_id = :id", nativeQuery = true)
    public List<Marks> getStudentMarks(@Param("id") int id);

    Optional<Marks> findByStudentId_StudentId(int studentId);


}
