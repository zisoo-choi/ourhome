package com.ourhome.demo.domain.product.service;

import com.ourhome.demo.domain.product.dto.response.ProductListResponseDTO;
import com.ourhome.demo.domain.product.dto.request.RegisterProductRequestDTO;
import com.ourhome.demo.domain.product.entity.Product;
import com.ourhome.demo.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    final private ProductRepository productRepository;

    @Override
    public ProductListResponseDTO list() {
        List<Product> list = productRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        ProductListResponseDTO response = new ProductListResponseDTO(list);
        return response;
    }

    @Override
    public Product register(RegisterProductRequestDTO request) {
        Optional<Product> maybeProduct = productRepository.findByName(request.getName());

        if (maybeProduct.isEmpty()) {
            Product newProduct = Product.builder()
                    .name(request.getName())
                    .price(request.getPrice())
                    .explanation(request.getExplanation())
                    .image(request.getImage())
                    .foodManagement(request.getFoodManagement())
                    .discountRate(request.getDiscountRate())
                    .build();
            log.info("새로운 상품 등록이 되었습니다.");
            return productRepository.save(newProduct);
        } else {
            log.info("이미 존재하는 상품입니다. 상품 등록이 되지 않았습니다.");
            return null;
        }
    }
}
