package com.ourhome.demo.domain.cart.controller;

import com.ourhome.demo.domain.cart.dto.request.AddProductToCartRequestDTO;
import com.ourhome.demo.domain.cart.dto.request.DecreasesProductRequestDTO;
import com.ourhome.demo.domain.cart.dto.response.ReturnedCartResponseDTO;
import com.ourhome.demo.domain.cart.service.CartService;
import com.ourhome.demo.domain.member.entity.Member;
import com.ourhome.demo.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    final private CartService cartService;

    @PostMapping("/add")
    public void cartAdd(@RequestBody AddProductToCartRequestDTO response){
        log.info("장바구니에 상품 추가 요청!");
        Member member = response.getMember();
        Product product = response.getProduct();
        cartService.addCart(member, product);
    }

    @GetMapping("/list")
    public ReturnedCartResponseDTO cartList(@RequestParam Long memberId){
        log.info("장바구니 목록 반환 요청!");
        return cartService.list(memberId);
    }

    @PostMapping("/decrease-product")
    public ReturnedCartResponseDTO decreaseProduct(@RequestBody DecreasesProductRequestDTO response){
        log.info("장바구니 수량 감소");
        Member member = response.getMember();
        Product product = response.getProduct();
        return cartService.decreasesProduct(member, product);
    }

    @PostMapping("/increase-product")
    public ReturnedCartResponseDTO increaseProduct(@RequestBody DecreasesProductRequestDTO response){
        log.info("장바구니 수량 증가");
        Member member = response.getMember();
        Product product = response.getProduct();
        return cartService.increaseProduct(member, product);
    }
}
