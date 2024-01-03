import { createStore } from 'vuex'
import ProductModule from './product/ProductModule'
import CartModule from './cart/CartModule'

export default createStore({
  state: {},
  getters: {},
  mutations: {},
  actions: {},
  modules: {
    ProductModule:ProductModule,
    CartModule:CartModule,
  }
})
