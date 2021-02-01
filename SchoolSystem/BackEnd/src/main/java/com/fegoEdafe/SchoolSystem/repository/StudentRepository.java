package com.fegoEdafe.SchoolSystem.repository;

import com.fegoEdafe.SchoolSystem.model.Students;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends PagingAndSortingRepository<Students, Long> {

    @Query("FROM Students b WHERE b.firstName LIKE %:searchText% OR b.lastName LIKE %:searchText% OR b.email LIKE %:searchText% ORDER BY b.id ASC")
    Page<Students> findAllBooks(Pageable pageable, @Param("searchText") String searchText);



    /*
    Optional<Students> findById();

     */
/**/
}
