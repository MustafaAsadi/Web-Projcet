package com.example.demo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<Instagram_User,Long> {
    @Modifying  // Mark the query as modifying
    @Transactional  // Ensure the operation is within a transaction4
    @Query(value = "DELETE FROM instagram_user WHERE user_id = :user_id ", nativeQuery = true)
    void removeUserById(@Param("user_id") Long user_id);

    @Modifying
    @Transactional
    @Query(value = "update instagram_user set doc = '2055-1-13' where user_id =:user_id",nativeQuery = true)
    void updateById(@Param("user_id") Long user_id);

}
