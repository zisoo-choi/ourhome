package com.ourhome.demo.domain.cart.dto.response;

import com.ourhome.demo.domain.cart.entity.Cart;
import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReturnedCartResponseDTO {
    private Cart cart;
}
