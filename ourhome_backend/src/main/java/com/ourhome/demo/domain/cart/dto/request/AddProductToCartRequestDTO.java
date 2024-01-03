package com.ourhome.demo.domain.cart.dto.request;

import com.ourhome.demo.domain.member.entity.Member;
import com.ourhome.demo.domain.product.entity.Product;
import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddProductToCartRequestDTO {
    private Member member;
    private Product product;
}
