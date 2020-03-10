import axios from 'axios'

// state
const state = {
};

// actions
const actions = {

    formUsuario ({commit, dispatch}, formData) {
        return new Promise((resolve, reject) => {
            axios.post('/formUsuario', {
                email: formData.email,
                password: formData.password,
                nome : formData.nome,
                habilitado: formData.checked
            })
            .catch(error => console.log(error))
            .finally(() => resolve())
        })
    },


    formCurso ({commit, dispatch}, formData) {
        return new Promise((resolve, reject) => {
            axios.post('/formCurso', {
                nome: formData.nome,
                sigla : formData.sigla,
                turno: formData.turno
            })
            .catch(error => console.log(error))
            .finally(() => resolve())
        })
    },

};

// getters
const getters = {
  
};

// mutations
const mutations = {
  
};

export default {
    namespaced: true,
    state,
    mutations,
    actions,
    getters
}
