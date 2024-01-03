package com.ourhome.demo.domain.product.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class RegisterProductRequestDTO {
    private String name;
    private Integer price;
    private String explanation;
    private String image;
    private Integer foodManagement;
    private Integer discountRate;
}
