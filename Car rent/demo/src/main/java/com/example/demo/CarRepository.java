package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Cars, Long> {

    // Query to search by username
    @Query(value = "SELECT * FROM Cars as c WHERE c.user_name = :username",nativeQuery = true)
    Optional<Cars> searchByUsername(String username);

    @Query(value = "SELECT * FROM Cars as c  WHERE c.password = :password",nativeQuery = true)
    Optional<Cars> searchByPassword(String password);
}
