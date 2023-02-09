package com.example.authorization.repository;

import com.example.authorization.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @autor Juan David Morantes Vergara
 */
@Repository
public interface ICartRepository extends JpaRepository<Cart,Long> {
    @Query("From Cart c where c.id_product=:id_product and c.id_user=:id_user")
    Cart verifiCartUser(Long id_product,Long id_user);
}
