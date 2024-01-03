import {
    REQUEST_CART_LIST_TO_SPRING
} from '../cart/mutation-types'

export default {
    [REQUEST_CART_LIST_TO_SPRING] (state, receiveData) {
        state.carts = receiveData;
    }
}