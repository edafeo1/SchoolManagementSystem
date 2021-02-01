package com.fegoEdafe.SchoolSystem.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class DaoService<T> {


    List<T> getAll() {
        return getRepository().findAll();
    }

    T findById(Long id) {
        return getRepository().findById(id).get();
    }


    abstract <R extends  JpaRepository<T, Long>> R getRepository();
}
