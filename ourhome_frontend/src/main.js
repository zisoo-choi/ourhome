import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import { loadFonts } from './plugins/webfontloader'
import { library } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import { faCartShopping, faXmark, faPlus, faEquals, faMinus } from '@fortawesome/free-solid-svg-icons';

// 플러그인 및 구성 요소 등을 추가
library.add(faCartShopping);
library.add(faXmark);
library.add(faPlus);
library.add(faEquals);
library.add(faMinus);
loadFonts();

// Vue 앱 생성
const app = createApp(App);

// 플러그인 및 구성 요소를 사용
app.use(router).use(store).use(vuetify);

// Vue Font Awesome 아이콘 컴포넌트 등록
app.component('font-awesome-icon', FontAwesomeIcon);

// 앱을 #app 요소에 마운트
app.mount('#app');
