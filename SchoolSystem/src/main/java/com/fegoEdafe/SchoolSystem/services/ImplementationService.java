package com.fegoEdafe.SchoolSystem.services;



import com.fegoEdafe.SchoolSystem.model.Students;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ImplementationService<T> {
    T Save(T t);

    void update(Long id, T t);

    void deleteById(long id);

    // Fix bug Here
    Optional<Students> findById(long id);

    List<T> findAll();

    List<T> findAll(int pageNum);
}
