package com.fegoEdafe.SchoolSystem.controller;

import com.fegoEdafe.SchoolSystem.model.Students;
import com.fegoEdafe.SchoolSystem.services.ImplementationService;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3002")
@RestController
@RequestMapping("/students")
public class StudentController implements GenericController<Students> {



    @Autowired
    private final ImplementationService<Students> studentService;

    public StudentController(ImplementationService<Students> studentService) {
        this.studentService = studentService;
    }

    @Override
    public Page<Students> findAllByText(Pageable pageable, String Text) {
        return studentService.findAllByText(pageable,Text);
    }

    @Override
    public Page<Students> findAll(int pageNo) {
        Page p = studentService.SelectPage(pageNo);
        return p;
        //return (Page<Students>) studentService.SelectPage(pageNo);
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
}
