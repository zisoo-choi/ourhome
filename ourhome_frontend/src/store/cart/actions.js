import axiosInst from "@/utility/axiosInst";
import {
    REQUEST_CART_LIST_TO_SPRING
} from "../cart/mutation-types";

export default {
    // 장바구니 목록 조회 (vuex에 저장 -> 화면 뿌려주기)
    async requestCartListToSpring({commit}, payload){
        return await axiosInst.get('/cart/list', { params: { memberId: payload }})
        .then((res) => {
            console.log(res.data.cart.cartProducts)
            commit(REQUEST_CART_LIST_TO_SPRING, res.data.cart.cartProducts);
        })
        .catch(() => {
            console.error;
        })
    },
    // 장바구니 상품 추가
    async responseCartAddToSpring(context, payload) {
        const { member, product } = payload;
        return await axiosInst.post("/cart/add", {
            member,
            product
        }).then(() => {
            console.log("상품 추가 완료");
            return true;
        }).catch(() => {
            console.error;
        })
    },
    // 장바구니 수량 감소
    async responseCartDecreaseToSpring({commit}, payload){
        const { member, product } = payload;
        return await axiosInst.post("/cart/decrease-product", {
            member,
            product
        }).then((res) => {
            console.log("장바구니 수량 감소");
            commit(REQUEST_CART_LIST_TO_SPRING, res.data.cart.cartProducts);
        }).catch(() => {
            console.error;
        })
    },
    // 장바구니 수량 증가
    async responseCartIncreaseToSpring({commit}, payload){
        const { member, product } = payload;
        return await axiosInst.post("/cart/increase-product", {
            member,
            product
        }).then((res) => {
            console.log("장바구니 수량 증가");
            commit(REQUEST_CART_LIST_TO_SPRING, res.data.cart.cartProducts);
        }).catch(() => {
            console.error;
        })
    }
}