package com.ourhome.demo.domain.cart.service;

import com.ourhome.demo.domain.cart.dto.response.ReturnedCartResponseDTO;
import com.ourhome.demo.domain.member.entity.Member;
import com.ourhome.demo.domain.product.entity.Product;

public interface CartService {
    void addCart(Member member, Product product);

    ReturnedCartResponseDTO list(Long memberId);

    ReturnedCartResponseDTO decreasesProduct(Member member, Product product);

    ReturnedCartResponseDTO increaseProduct(Member member, Product product);
}
