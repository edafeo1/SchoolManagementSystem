package com.fegoEdafe.SchoolSystem.services;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ImplementationService<T> {
    void Save(T t);

    void update(Long id, T t);

    void deleteById(long id);

    // Fix bug Here
    Optional<T> findById(long id);

    List<T> getAll();

    Page<T> SelectPage(int pageNo);

    Page<T > findAllByText(Pageable pageable, String text);


}
