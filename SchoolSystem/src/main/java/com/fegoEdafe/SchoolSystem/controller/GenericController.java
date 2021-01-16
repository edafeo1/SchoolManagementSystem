package com.fegoEdafe.SchoolSystem.controller;

import com.fegoEdafe.SchoolSystem.model.Students;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
public interface GenericController<T> {

    @GetMapping("/search/{text}")
     Page<T> findAllByText(Pageable pageable, @PathVariable("text") String Text);

    @GetMapping("/page/{pageNo}")
     Page<T> findAll(@PathVariable("pageNo") int pageNo);


    @GetMapping(path = "{id}")
     Optional<T> findById(@PathVariable("id") long id);

    @DeleteMapping(path = "{id}")
     void deleteById(@PathVariable("id") long id);


    @PutMapping(path = "{id}")
     void updateById(@PathVariable("id") long id, @RequestBody T t);

    @PostMapping
     void Save(@RequestBody T t);
}

/*
    @GetMapping("/search/{searchText}")
    List<Page<T>> findAll(Pageable pageable, @PathVariable String searchText);

    @GetMapping
    List<Page<T>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir);

    @GetMapping("{id}")
    List<T> findById(@PathVariable Long id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<T> save(@RequestBody T t);

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<T> update(@RequestBody T t);

    @DeleteMapping("{id}")
    List<String> deleteById(@PathVariable Long id);

 */