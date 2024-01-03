<template>
    <v-container>
        <div class="cartListContainer">
            <table style="border-collapse: collapse;">
                <tr class="cartListTitle">
                    <th align="center" width="30%">상품명</th>
                    <th align="center" width="8%">구매가</th>
                    <th align="center" width="10%">수량</th>
                    <th align="center" width="8%">금액</th>
                </tr>
                <tr v-for="item in cartItems" :key="item.id" class="cartListProductBox">
                    <td class="test">
                        <img :src=item.product.image style="width:25%" class="cartListImage">
                        <span v-html="item.product.name" class="cartListProductName"></span>
                    </td>
                    <td class="cartListProductPrice cartDicountAndCost" align="center">
                        <div>{{ formatPrice(item.product.discountPrice) }}원</div>
                        <div v-if="item.product.discountRate > 0" class="cartCost">{{ formatPrice(item.product.price) }}원</div>
                    </td>
                    <td align="center">
                        <div class="cartListBtnBox">
                            <button @click="decreaseQuantity(item.product)" class="cartListBtn">
                                <font-awesome-icon icon="fa-solid fa-minus" class="iconCss"/>
                            </button>
                            <p class="cartListQuantity">{{ item.count }}</p>
                            <button @click="increaseQuantity(item.product)" class="cartListBtn">
                                <font-awesome-icon icon="fa-solid fa-plus" class="iconCss"/>
                            </button>
                        </div>
                    </td>
                    <td align="center" class="cartListProductPrice">
                        {{ formatPrice(item.product.discountPrice * item.count) }}원
                    </td>
                </tr>
            </table>
            <div class="cartListBottom">
                <div class="cartListTotalAmount">
                    <p class="cartListTitlePtag">총 금액</p>
                    <p class="cartListAmountPtag">{{ formatPrice(calculateTotalPrice()) }}원</p>
                </div>
                <p class="cartListIcon">
                    <font-awesome-icon icon="fa-solid fa-plus" />
                </p>
                <div class="cartListShopingCost">
                    <p class="cartListTitlePtag">배송비</p>
                    <p v-if="calculateTotalPrice() >= 30000" class="cartListAmountPtag">0원</p>
                    <p v-else class="cartListAmountPtag">{{ formatPrice(3000) }} 원</p>
                    <p class="cartListFreeDevlivery">(3만원이상 구매 시 무료배송)</p>
                </div>
                <p class="cartListIcon">
                    <font-awesome-icon icon="fa-solid fa-equals" />
                </p>
                <div class="cartListPaymentAmount">
                    <p class="cartListTitlePtag">결제 금액</p>
                    <p class="cartListAmountPtag">{{ formatPrice(calculatePaymentPrice()) }}원</p>
                </div>
            </div>
        </div>
    </v-container>
</template>

<script>
import '@/assets/css/cart/cartList.css'
import { mapState, mapActions } from 'vuex';

const CartModule = 'CartModule';

export default {
    props: {
        cartItems: {
            type: Array
        }
    },
    name: 'CardListForm',
    data () {
        return {
            memberId: 1,
        }
    },
    computed: {
        ...mapState(CartModule, ['carts'])
    },
    methods: {
        ...mapActions(CartModule, ['responseCartDecreaseToSpring', 'responseCartIncreaseToSpring']),
        formatPrice(price){
            return price.toLocaleString();
        },
        async decreaseQuantity(item){
            const payload = {
                member: this.memberId,
                product: item
            };
            await this.responseCartDecreaseToSpring(payload);
        },
        async increaseQuantity(item){
            const payload = {
                member: this.memberId,
                product: item
            };
            await this.responseCartIncreaseToSpring(payload);
        },
        calculateTotalPrice() {
            // reduce : 배열의 각 항목에 대한 누적된 값을 계산하는 자바 스크립트
            let totalAmount = 0;

            for (let i = 0; i < this.carts.length; i++) {
                const item = this.carts[i];
                totalAmount += item.product.discountPrice * item.count;
            }
            return totalAmount;
        },
        calculatePaymentPrice() {
            let paymentAmount = this.calculateTotalPrice();

            if(paymentAmount >= 30000){
                return paymentAmount;
            } else {
                return paymentAmount + 3000;
            }
        }
    },
}
</script>

<style lang="css" scoped></style>