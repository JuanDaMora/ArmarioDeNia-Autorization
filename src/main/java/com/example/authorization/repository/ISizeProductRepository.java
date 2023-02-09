package com.example.authorization.repository;

import com.example.authorization.model.SizeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autor Juan David Morantes Vergara
 */
@Repository
public interface ISizeProductRepository extends JpaRepository<SizeProduct,Long> {
    @Query("From SizeProduct  s where s.id_product=:id ")
    List<SizeProduct> getAllByIdProduct(Long id);
}
