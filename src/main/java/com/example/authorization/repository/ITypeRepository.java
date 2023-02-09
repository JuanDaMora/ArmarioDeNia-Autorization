package com.example.authorization.repository;

import com.example.authorization.model.Type;
import com.example.authorization.model.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @autor Juan David Morantes Vergara
 */
@Repository
public interface ITypeRepository extends JpaRepository<Type,Long> {
    @Query("From Type t Where t.id=:id")
    Type getByIdProduct(Long id);
}
