package com.fegoEdafe.SchoolSystem.repository;

import com.fegoEdafe.SchoolSystem.model.Students;
import com.fegoEdafe.SchoolSystem.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Repository
public interface UseRepository extends PagingAndSortingRepository<User, Long> {

    @Query("FROM User b WHERE b.firstName LIKE %:searchText% OR b.lastName LIKE %:searchText% OR b.email LIKE %:searchText% ORDER BY b.id ASC")
    Page<User> findAllUsers(Pageable pageable, @PathVariable String searchText);

    }
