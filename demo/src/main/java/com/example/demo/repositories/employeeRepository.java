package com.example.demo.repositories;

import com.example.demo.classes.employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Modifying
    @Transactional
    @Query(value = "UPDATE Employee c SET c.username = :username WHERE c.id = :id",nativeQuery = true)
    void updateEmployeeUsername(@Param("id") Long id, @Param("username") String username);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Employee c SET c.password = :password WHERE c.id = :id",nativeQuery = true)
    void updateEmployeePassword(@Param("id")Long longId, @Param("password") String password);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Employee c SET c.position = :position WHERE c.id = :id",nativeQuery = true)
    void updateEmployeePositon(@Param("id") Long longId, @Param("position") String position);


    @Modifying
    @Transactional
    @Query(value = "UPDATE Employee c SET c.email = :email WHERE c.id = :id",nativeQuery = true)
    void updateEmployeeEmail(@Param("id")Long longId, @Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Employee c SET c.salary = :salary WHERE c.id = :id",nativeQuery = true)
    void updateEmployeeSalary(@Param("id")Long longId,@Param("salary") Float salary);


}

