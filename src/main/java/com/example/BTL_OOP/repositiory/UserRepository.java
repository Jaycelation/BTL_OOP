package com.example.BTL_OOP.repositiory;

import com.example.BTL_OOP.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

  boolean existsByEmail(String email);
  @Query("""
        SELECT u FROM User u WHERE u.email = :username
        """)
  Optional<User> findByUsername(String username);
}
