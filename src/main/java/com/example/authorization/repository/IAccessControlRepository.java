package com.example.authorization.repository;

import com.example.authorization.model.AccessControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Daniel Adrian Gonzalez Buendia
 */
@Repository
public interface IAccessControlRepository extends JpaRepository<AccessControl, Long> {

    Optional<AccessControl> findDistinctTopByIdUser(Long userId);

}
