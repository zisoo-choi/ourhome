<template>
    <v-container>
        <v-row class="container">
            <v-col v-for="item in productList" :key="item.id" cols="4" md="3">
                <div>
                    <h2>{{ "0" + item.id }}</h2>
                    <div class="imageBox">
                        <v-img :src=item.image class="imgContainer">
                            <v-btn @click="addCart(item)" icon="$vuetify" class="cartBtn">
                                <font-awesome-icon icon="fa-cart-shopping" class="icon"/>
                            </v-btn>
                        </v-img>
                    </div>
                    <div class="productName">{{ item.name }}</div>
                    <div class="productExnt">{{ item.explanation }}</div>
                    <div class="productPriceBox">
                        <div class="productPrice">{{ formatPrice(item.discountPrice) }}<span class="krw">원</span></div>
                        <div v-if="item.discountRate > 0" class="cost">{{ formatPrice(item.price) }}원</div>
                        <div v-if="item.discountRate > 0" class="productDiscountRate">{{ item.discountRate }}%</div>
                    </div>
                    <div class="productOption" :class="{ 'blue-text': item.foodManagement === 2, 'skyblue-text': item.foodManagement === 3 }">
                        {{ item.foodManagement === 1 ? '실온' : item.foodManagement === 2 ? '냉동' : '냉장' }}
                    </div>
                </div>
            </v-col>
        </v-row>
    </v-container>
    <Modal v-if="isModalViewed" @cancle="cancelModal"/>
</template>

<script>
import Modal from '@/components/productList/Modal.vue';
import '@/assets/css/product/productList.css'
import { mapActions } from 'vuex';

const CartModule = 'CartModule';

export default {
    name: 'ProductListForm',
    props: {
        productList: {
            type: Array
        }
    },
    components:{
        Modal
    },
    data() {
        return {
            isModalViewed: false,
            memberId: 1
        }
    },
    methods: {
        ...mapActions(CartModule, ['responseCartAddToSpring']),
        // 자바 스크립트에서 제공하는 3자리 단위마다 ,를 추가해주는 메소드
        formatPrice(price){
            return price.toLocaleString();
        },
        cancelModal() {
            this.isModalViewed = false;
        },
        async addCart(prodcut){
            const payload = {
                member: this.memberId,
                product: prodcut
            };
            if(await this.responseCartAddToSpring(payload)){
                this.isModalViewed = true;
            }
        }
    }
}
</script>

<style lang="css" scoped></style>