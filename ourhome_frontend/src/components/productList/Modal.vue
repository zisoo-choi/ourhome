<template>
    <div>
      <div class="black-bg">
        <div class="white-bg">
            <div class="cartModalTopBar">
                <h3>장바구니</h3>
                <v-btn class="xmarkBtn" flat @click="cancle">
                    <font-awesome-icon icon="fa-xmark" />
                </v-btn>
            </div>
            <hr>
            <div class="popUpText">
              <div class="cartPopUpText">
                  <p style="font-weight: bold; margin: 3px;">선택한 상품이 장바구니에 담겼습니다.</p>
                  <p style="font-weight: bolder; color: rgb(136, 136, 136);">장바구니로 이동 하겠습니끼?</p>
              </div>
              <div>
                  <v-btn class="popUpBtn" style="font-weight: 500; width: 170px; height: 45px; background-color: rgb(163, 163, 163); color: white;" @click="goToCartList">장바구니 확인하기</v-btn>
                  <v-btn class="popUpBtn" style="font-weight: 500; width: 140px; height: 45px; background-color: rgb(255, 103, 21); color: white;" @click="cancle">계속 쇼핑하기</v-btn>
              </div>
            </div>
        </div>
      </div>
    </div>
</template>

<script>
import '@/assets/css/product/modal.css'

export default {
    methods: {
        cancle() {
            this.$emit('cancle');
        },
        goToCartList(){
          this.$router.push('/cartList')
        }
    }
}
</script>

<style lang="css" scoped></style>