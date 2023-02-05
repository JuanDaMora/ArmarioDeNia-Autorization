package com.example.authorization.repository;

import com.example.authorization.model.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @autor Juan David Morantes Vergara
 */
@Repository
public interface ITypeProductRepository extends JpaRepository<TypeProduct,Long> {
}
