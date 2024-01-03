package com.ourhome.demo.domain.product.controller;

import com.ourhome.demo.domain.product.dto.response.ProductListResponseDTO;
import com.ourhome.demo.domain.product.dto.request.RegisterProductRequestDTO;
import com.ourhome.demo.domain.product.entity.Product;
import com.ourhome.demo.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    final private ProductService productService;

    // 상품 목록 반환
    @GetMapping("/list")
    public ProductListResponseDTO productList(){
        log.info("상품 목록 반환!");
        ProductListResponseDTO response = productService.list();
        return response;
    }

    // 상품 등록
    @PostMapping("/register")
    public Product registerProduct(@RequestBody RegisterProductRequestDTO request) {
        log.info("상품 등록!");
        return productService.register(request);
    }
}
