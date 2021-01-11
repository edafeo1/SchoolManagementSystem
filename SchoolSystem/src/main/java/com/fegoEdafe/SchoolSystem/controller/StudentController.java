package com.fegoEdafe.SchoolSystem.controller;

import com.fegoEdafe.SchoolSystem.model.Students;
import com.fegoEdafe.SchoolSystem.services.ImplementationService;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/students")
public class StudentController implements GenericController<Students> {

    @Autowired
    private final ImplementationService<Students> studentService;

    public StudentController(ImplementationService<Students> studentService) {
        this.studentService = studentService;
    }

/*
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

 */

    @Override
    public List<Students> findAll(int pageNo) {
        List<Students> students = studentService.findAll(pageNo);
        return students;
    }

    @Override
    public List<Students> findAll() {
        //Casting Example
        return (List<Students>) studentService.findAll();
    }

    @Override
    public Optional<Students> findById(long id) {
        return studentService.findById(id);
    }

    @Override
    public void deleteById(long id) {
        studentService.deleteById(id);
    }

    @Override
    public void updateById(long id, Students students) {
        studentService.update(id, students);
    }

    @Override
    public void Save(Students students) {
        studentService.Save(students);
    }
}
