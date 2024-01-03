import {
    REQUEST_PRODUCT_LIST_TO_SPRING
} from '../product/mutation-types'

export default {
    [REQUEST_PRODUCT_LIST_TO_SPRING] (state, receiveData) {
        state.productList = receiveData;
    }
}