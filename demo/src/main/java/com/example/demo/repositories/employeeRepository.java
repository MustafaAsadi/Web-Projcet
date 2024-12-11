package com.example.demo.repositories;

import com.example.demo.classes.employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface employeeRepository extends JpaRepository<employee,Long> {
    @Query(value = "SELECT * FROM employee c where c.email = :email",nativeQuery = true)
    employee searchForUser(String email);

    @Query(value = "SELECT * FROM employee c where c.email = :email" , nativeQuery = true)
    Optional<employee> searchByEmail(String email);

    @Query(value = "SELECT * FROM employee c where c.password = :password" , nativeQuery = true)
    Optional<employee> searchByPassword(String password);

    //@Modifying
    //@Transactional
   // @Query(value = "UPDATE employee c set username = c.username WHERE c.")//username update



}

