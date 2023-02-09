package com.example.authorization.repository;

import com.example.authorization.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autor Juan David Morantes Vergara
 */
@Repository
public interface IColorRepository extends JpaRepository<Color, Long> {

}
