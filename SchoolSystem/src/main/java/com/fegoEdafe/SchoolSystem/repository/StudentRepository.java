package com.fegoEdafe.SchoolSystem.repository;

import com.fegoEdafe.SchoolSystem.model.Students;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {

    List<Students> findAllBy(Pageable pageable);

    /*
    Optional<Students> findById();

     */
/**/
}
