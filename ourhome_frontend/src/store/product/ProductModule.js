import state from '@/store/product/states'
import actions from '@/store/product/actions'
import mutations from '@/store/product/mutations'

const ProductModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}
export default ProductModule