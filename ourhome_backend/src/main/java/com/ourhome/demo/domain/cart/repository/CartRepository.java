package com.ourhome.demo.domain.cart.repository;

import com.ourhome.demo.domain.cart.dto.response.ReturnedCartResponseDTO;
import com.ourhome.demo.domain.cart.entity.Cart;
import com.ourhome.demo.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query(value = "SELECT c FROM Cart c WHERE c.member.id = :id")
    Cart findByMemberId(Long id);

    @Query("SELECT DISTINCT c FROM Cart c LEFT JOIN FETCH c.cartProducts cp " +
            "LEFT JOIN FETCH cp.product p LEFT JOIN FETCH c.member WHERE c.member = :member")
    ReturnedCartResponseDTO findCartFetchJoin(@Param("member") Member member);

    @Query("SELECT DISTINCT c FROM Cart c LEFT JOIN FETCH c.cartProducts cp " +
            "LEFT JOIN FETCH cp.product p LEFT JOIN FETCH c.member WHERE c.member.id = :memberId")
    ReturnedCartResponseDTO findCartWithDetails(@Param("memberId") Long memberId);
}
