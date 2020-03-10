import axios from 'axios'

// state
const state = {

};

// actions
const actions = {
        removeUsuario ({commit, dispatch}, formData) {
            return new Promise((resolve, reject) => {
                axios.delete('/deletarUsuario/'+formData.email)
                .catch(error => console.log(error))
                .finally(() => resolve())
            })
        },

        removeCurso ({commit, dispatch}, formData) {
            return new Promise((resolve, reject) => {
                axios.delete('/deleteCurso/'+formData.id)
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
