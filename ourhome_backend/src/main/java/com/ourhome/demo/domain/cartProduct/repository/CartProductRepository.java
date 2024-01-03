package com.ourhome.demo.domain.cartProduct.repository;

import com.ourhome.demo.domain.cartProduct.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
    Optional<CartProduct> findByProductIdAndCartId(Long id, Long id1);
}
