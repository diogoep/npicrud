import Vue from 'vue'
import Vuex from 'vuex'

import auth from './modules/auth'
import create from './modules/create' 
import edit from './modules/edit' 
import remove from './modules/remove' 
Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    auth: auth,
    create: create,
    edit: edit,
    remove: remove
  }
})
