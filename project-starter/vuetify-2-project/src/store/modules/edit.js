import axios from 'axios'

// state
const state = {
};

// actions
const actions = {

    editUsuario ({commit, dispatch}, formData) {
        return new Promise((resolve, reject) => {
            axios.post('/editUsuario/'+formData.email1, {
                email: formData.email,
                password: formData.password,
                nome : formData.nome,
                habilitado: formData.checked
            })
            .catch(error => console.log(error))
            .finally(() => resolve())
        })
    },
    editCurso ({commit, dispatch}, formData) {
        return new Promise((resolve, reject) => {
            axios.put('/editCurso/' + formData.id, {
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
