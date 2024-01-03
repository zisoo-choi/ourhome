package com.ourhome.demo.domain.product.service;

import com.ourhome.demo.domain.product.dto.response.ProductListResponseDTO;
import com.ourhome.demo.domain.product.dto.request.RegisterProductRequestDTO;
import com.ourhome.demo.domain.product.entity.Product;

public interface ProductService {
    ProductListResponseDTO list();

    Product register(RegisterProductRequestDTO request);
}
