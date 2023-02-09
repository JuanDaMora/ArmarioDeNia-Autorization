package com.example.authorization.repository;

import com.example.authorization.model.ColorProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autor Juan David Morantes Vergara
 */
@Repository
public interface IColorProductRespository extends JpaRepository<ColorProduct,Long> {
    @Query("From ColorProduct c where c.id_product=:id")
    List<ColorProduct> getAllByIdProduct(Long id);
}
