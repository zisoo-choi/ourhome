package com.ourhome.demo.domain.product.dto.response;

import com.ourhome.demo.domain.product.entity.Product;
import lombok.*;

import java.util.List;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductListResponseDTO {
    private List<Product> productList;
}
