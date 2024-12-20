package com.example.demo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface customerRepository extends JpaRepository<customer,Long> {

    @Query(value = "SELECT * FROM customer c WHERE c.username = :username", nativeQuery = true)
    Optional<customer> searchByUsername(String username);

    @Query(value = "SELECT * FROM customer c WHERE c.password = :password", nativeQuery = true)
    Optional<customer> searchByPassword(String password);

    @Query(value = "SELECT * FROM customer c WHERE c.username = :username", nativeQuery = true)
    customer searchForUser(String username);

}
