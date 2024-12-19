package com.example.demo.repositories;

import com.example.demo.classes.customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface customerRepository extends JpaRepository<customer,Long> {

    @Query(value = "SELECT * FROM customer c WHERE c.email = :email", nativeQuery = true)
    Optional<customer> searchByEmail(String email);

    @Query(value = "SELECT * FROM customer c WHERE c.password = :password", nativeQuery = true)
    Optional<customer> searchByPassword(String password);

    @Query(value = "SELECT * FROM customer c WHERE c.email = :email", nativeQuery = true)
    customer searchForUser(String email);

    @Query(value = "SELECT email FROM  customer c WHERE c.email = :email ", nativeQuery = true)
    String SearchForEmail(String email);



    @Modifying
    @Transactional
    @Query(value = "UPDATE customer c SET c.password = :password WHERE c.email = :email ",nativeQuery = true)
    void resetPassword(@Param("password")String password,@Param("email") String email);
}
