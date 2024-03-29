import axiosInst from "@/utility/axiosInst";
import {
    REQUEST_PRODUCT_LIST_TO_SPRING
} from "../product/mutation-types";

export default {
    async requestProductListToSpring({commit}){
        return await axiosInst.get("/product/list")
        .then((res) => {
            commit(REQUEST_PRODUCT_LIST_TO_SPRING, res.data.productList);
        })
        .catch(() => {
            console.error;
        })
    },
}