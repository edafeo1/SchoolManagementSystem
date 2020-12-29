package com.fegoEdafe.SchoolSystem.controller;

import com.fegoEdafe.SchoolSystem.model.Students;
import com.fegoEdafe.SchoolSystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Students> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "{id}")
    public Students getStudentById(@PathVariable("id") long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudentsById(@PathVariable("id") long id){
        studentService.deleteStudentById(id);
    }
    

    @PutMapping(path = "{id}")
    public void updateStudentById(@PathVariable("id") long id ,@RequestBody Students student){
        studentService.updateStudentById(id, student );
    }

    @PostMapping
    public void addStudent (@RequestBody Students student){
        studentService.addStudent(student);

    }

}
