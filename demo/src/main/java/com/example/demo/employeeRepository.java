package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface employeeRepository extends JpaRepository<employee,Long> {
    @Query(value = "SELECT * FROM employee c where c.username = :username",nativeQuery = true)
    employee searchForUser(String username);

    @Query(value = "SELECT * FROM employee c where c.username = :username" , nativeQuery = true)
    Optional<employee> searchByUsername(String username);

    @Query(value = "SELECT * FROM employee c where c.password = :password" , nativeQuery = true)
    Optional<employee> searchByPassword(String password);


}
