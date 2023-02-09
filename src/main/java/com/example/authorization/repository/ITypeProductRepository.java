package com.example.authorization.repository;

import com.example.authorization.model.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autor Juan David Morantes Vergara
 */
@Repository
public interface ITypeProductRepository extends JpaRepository<TypeProduct,Long> {
    @Query("From TypeProduct t Where t.id_product=:id_product")
    TypeProduct getTypeProductById_product(Long id_product);
}
