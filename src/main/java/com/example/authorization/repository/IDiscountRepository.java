package com.example.authorization.repository;

import com.example.authorization.model.Discount;
import com.example.authorization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @autor Juan David Morantes Vergara
 */
@Repository
public interface IDiscountRepository extends JpaRepository<Discount,Long> {
    @Query("FROM Discount d WHERE (d.id_product) = (:id)")
    Optional<Discount> findTopByIdProduct(Long id);
}
