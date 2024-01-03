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
            double discountRate = this.discountRate * 0.01; // 할인율을 0과 1 사이의 값으로 변환
            double discountedPrice = this.price - (this.price * discountRate);
            // 소수점 이하 반올림
            this.discountPrice = (int) Math.round(discountedPrice);

            int lastDigit = this.discountPrice % 10;
            if (lastDigit > 0) {
                // 할인 가격의 일의 자리가 1 이상이면 일의 자리 값을 제거
                this.discountPrice -= lastDigit;
            }
        }
    }
}
