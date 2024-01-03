<template>
    <div>
        <ProductListForm :productList="productList"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import ProductListForm from '@/components/productList/ProductListForm.vue';

const ProductModule = 'ProductModule';

export default {
    name: "ProductListPage",
    components: {
        ProductListForm,
    },
    computed: {
        ...mapState(ProductModule, ["productList"])
    },
    async mounted() {
        await this.requestProductListToSpring();
    },
    methods: {
        ...mapActions(ProductModule, ["requestProductListToSpring"]),
    },
}
</script>

<style></style>