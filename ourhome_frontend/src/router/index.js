import { createRouter, createWebHistory } from 'vue-router'
import mainRouter from './product'
import cartRouter from './cart'

const routes = [
  ...mainRouter,
  ...cartRouter,
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
