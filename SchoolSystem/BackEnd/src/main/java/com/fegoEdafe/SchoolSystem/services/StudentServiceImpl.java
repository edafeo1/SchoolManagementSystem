package com.fegoEdafe.SchoolSystem.services;


import com.fegoEdafe.SchoolSystem.model.Students;
import com.fegoEdafe.SchoolSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements ImplementationService<Students> {
//public class StudentServiceImpl extends DaoService<Students> implements StudentService {


    @Autowired
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void Save(Students student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Long id, Students student) {
        Students updateStudent = studentRepository.findById(id).orElse(null);
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setLastName(student.getLastName());
        updateStudent.setEmail(student.getEmail());

        studentRepository.save(updateStudent);
    }

    @Override
    public void deleteById(long id) {
        Students deleteStudent = studentRepository.findById(id).orElse(null);
        assert deleteStudent != null;
        studentRepository.delete(deleteStudent);
    }

    @Override
    public Optional<Students> findById(long id) {
        return Optional.ofNullable(studentRepository.findById(id).orElse(null));
    }

    @Override
    public List<Students> getAll() {
        return (List<Students>) studentRepository.findAll();
    }

    @Override
    public Page<Students> SelectPage(int pageNo) {
        int size = 5;
        Pageable page = PageRequest.of(pageNo, size);
        return studentRepository.findAll(page);
    }



    @Override
    public Page<Students> findAllByText(Pageable pageable, String text) {
        return studentRepository.findAllBooks(pageable, text);
    }



    /*

    @Override
    StudentRepository getRepository() {
        return studentRepository;
    }

  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!IMPORTANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
   When creating or working with services, the below code works perfect
   It is best to use interfaces and implement those interfaces rather
   than implementing a class directly in the controller.

   writing code like this makes it easier and flexible once im used to it
   this way, my Impl servic einterface can also be implemented by other beans
   for example users.


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


    public void updateStudentById(long id, Students student){
        Students updateStudent = studentRepository.findById(id).orElse(null);
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setLastName(student.getLastName());
        updateStudent.setEmail(student.getEmail());

        studentRepository.save(updateStudent);

    }


 */



/*
    @Override
    public List<Students> findAll(int pageNum) {
        // /students?page=0
        Pageable page = PageRequest.of(pageNum, 10, Sort.by("name"));
        return studentRepository.findAllBy(page);
    }

 */
}
