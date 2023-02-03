package com.example.authorization.repository;

import com.example.authorization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @autor Juan David Morantes Vergara
 */
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("FROM User u WHERE upper(u.username) = upper(:username)")
    Optional<User> findTopByUsername(String username);
}
