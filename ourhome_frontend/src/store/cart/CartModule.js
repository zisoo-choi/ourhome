import state from '@/store/cart/states'
import actions from '@/store/cart/actions'
import mutations from '@/store/cart/mutations'

const CartModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}
export default CartModule