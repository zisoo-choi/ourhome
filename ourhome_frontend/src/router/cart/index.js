import CartListPage from '@/views/cartList/CartListPage'

const cartRouter = [
  {
    path: '/cartList',
    name: 'cartList',
    component: CartListPage,
    props: (route) => ({
      carts: route.query.carts,
    }),
  },
]
export default cartRouter
