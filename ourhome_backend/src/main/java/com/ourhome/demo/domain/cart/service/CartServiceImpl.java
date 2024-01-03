package com.ourhome.demo.domain.cart.service;

import com.ourhome.demo.domain.cart.dto.response.ReturnedCartResponseDTO;
import com.ourhome.demo.domain.cart.entity.Cart;
import com.ourhome.demo.domain.cartProduct.entity.CartProduct;
import com.ourhome.demo.domain.cart.repository.CartRepository;
import com.ourhome.demo.domain.cartProduct.repository.CartProductRepository;
import com.ourhome.demo.domain.member.entity.Member;
import com.ourhome.demo.domain.member.repository.MemberRepository;
import com.ourhome.demo.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    final private CartRepository cartRepository;
    final private CartProductRepository cartProductRepository;
    final private MemberRepository memberRepository;

    @Override
    public void addCart(Member member, Product product){
        Cart cart = cartRepository.findByMemberId(member.getId());

        if(cart == null){
            Cart addCart = new Cart(member);
            cartRepository.save(addCart);
            log.info("장바구니를 새로 만들었습니다.");
        }

        Optional<CartProduct> maybeCartProduct =
                cartProductRepository.findByProductIdAndCartId(product.getId(), cart.getId());

        if(maybeCartProduct.isEmpty()){
            CartProduct cartProduct = new CartProduct(cart, product);
            cartProduct.addCount();
            cartProductRepository.save(cartProduct);
            log.info("CartProduct 생성 후 새로운 상품을 추가했습니다.");
        } else {
            CartProduct cartProduct = maybeCartProduct.get();
            cartProduct.addCount();
            cartProductRepository.save(cartProduct);
            log.info("CartProduct 내에 존재하는 기존 상품의 수량을 증가했습니다.");
        }
    }

    @Override
    public ReturnedCartResponseDTO list(Long memberId){
        Optional<Member> maybeMember = memberRepository.findById(memberId);

        if(maybeMember.isEmpty()){
            log.info("존재하지 않는 회원입니다.");
            return null;
        }

        Member member = maybeMember.get();
        ReturnedCartResponseDTO responseDAO = cartRepository.findCartFetchJoin(member);
        return responseDAO;
    }

    @Override
    public ReturnedCartResponseDTO decreasesProduct(Member member, Product product){
        Cart cart = cartRepository.findByMemberId(member.getId());

        Optional<CartProduct> maybeCartProduct =
                cartProductRepository.findByProductIdAndCartId(product.getId(), cart.getId());

        if(maybeCartProduct.isEmpty()){
            log.info("장바구니에 존재하지 않는 상품입니다.");
            return null;
        }

        CartProduct cartProduct = maybeCartProduct.get();

        if (cartProduct.getCount() > 1) {
            cartProduct.minusCount();
            cartProductRepository.save(cartProduct);
        }
        cartRepository.save(cart);

        return cartRepository.findCartWithDetails(member.getId());
    }

    @Override
    public ReturnedCartResponseDTO increaseProduct(Member member, Product product){
        Cart cart = cartRepository.findByMemberId(member.getId());

        Optional<CartProduct> maybeCartProduct =
                cartProductRepository.findByProductIdAndCartId(product.getId(), cart.getId());

        if(maybeCartProduct.isEmpty()){
            log.info("장바구니에 존재하지 않는 상품입니다.");
            return null;
        }

        CartProduct cartProduct = maybeCartProduct.get();
        cartProduct.addCount();
        cartProductRepository.save(cartProduct);
        cartRepository.save(cart);

        return cartRepository.findCartWithDetails(member.getId());
    }
}
