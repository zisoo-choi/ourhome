<template>
    <div>
        <CartListForm :cartItems="carts"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import CartListForm from '@/components/cartList/CartListForm.vue';

const CartModule = 'CartModule';

export default {
    name: "CartListPage",
    data(){
        return {
            memberId: 1,
        }
    },
    components: {
        CartListForm
    },
    computed: {
        ...mapState(CartModule, ["carts"])
    },
    mounted(){
        this.requestCartListToSpring(this.memberId);
    },
    methods: {
        ...mapActions(CartModule, ['requestCartListToSpring']),
    }
}
</script>

<style></style>