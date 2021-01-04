package com.fegoEdafe.SchoolSystem.services;


import com.fegoEdafe.SchoolSystem.model.Students;
import com.fegoEdafe.SchoolSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Students addStudent(Students student){
        return studentRepository.save(student);
    }

    public List<Students> getAllStudents(){
        return studentRepository.findAll();
    }

    public Students getStudentById (long id){
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudentById(long id){
        Students deleteStudent = studentRepository.findById(id).orElse(null);
        assert deleteStudent != null;
        studentRepository.delete(deleteStudent);


    }

// Fix bug Here
    public void updateStudentById(long id, Students student){
        Students updateStudent = studentRepository.findById(id).orElse(null);
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setLastName(student.getLastName());
        updateStudent.setEmail(student.getEmail());

        studentRepository.save(updateStudent);

    }



}