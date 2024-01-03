package com.ourhome.demo.domain.product.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer price;
    private String explanation;
    private String image;
    private Integer foodManagement;
    private Integer discountRate;
    private Integer discountPrice;

    public Product(Long productId){
        this.id = productId;
    }

    @PrePersist
    public void prePersist() {
        // 할인 가격을 기본값으로 설정
        if (this.price != null && this.discountRate != null) {
            this.discountPrice = this.price - (this.price * this.discountRate / 100);
        }
    }
}
