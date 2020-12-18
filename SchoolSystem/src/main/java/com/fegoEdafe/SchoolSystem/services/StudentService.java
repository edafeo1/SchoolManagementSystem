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

        studentRepository.deleteById(id);


    }


    public int updateStudent(long id, Students student){
        return studentRepository.findById(id)
                .map(s -> {
                    long indexToReplace = id;
                    if(indexToReplace >= 0){
                        studentRepository.save(new Students(student.getFirstName() , student.getLastName(), student.getEmail()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }



}