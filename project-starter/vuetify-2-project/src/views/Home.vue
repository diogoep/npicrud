<template>
  <div>
    <v-card-widget enableActions :title="'Página Inicial'">
      <div slot="widget-header-action">

      </div>
      <div slot="widget-content">
        <v-row>
          <v-col cols="12">
            <v-data-table
                    :headers="headers"
                    :items="usuarios"
                    :items-per-page="5"
                    class="elevation-1"
            >
              <template v-slot:item.action="{ item }">
                <v-btn icon :to="{path: 'editUsuario/'+item.email}" color="primary" dark>
                  <v-icon small>
                    mdi-pencil
                  </v-icon>
                </v-btn>
                <v-btn icon :to="{path: 'deletarUsuario/'+item.email}" color="primary" dark>
                  <v-icon small @click="remove(item)">  
                    mdi-delete
                  </v-icon>
                </v-btn>
              </template>
            </v-data-table> 
          </v-col>
        </v-row>
        <v-btn raised to="/formUsuario" color="primary" dark>Adicionar Usuário</v-btn>
      </div>
      
    </v-card-widget>
  
  </div>
  
</template>

<script>
// @ is an alias to /src
import VCardWidget from "@/components/VWidget";
import {RepositoryFactory} from "@/repositories/RepositoryFactory";
const usuarioRepo = RepositoryFactory.get("usuario");
import axios from 'axios';

export default {
  name: 'home',
  components: {
    VCardWidget
  },

  data: () => ({
    headers: [
      {
        text: 'Nome',
        align: 'left',
        value: 'nome',
      },
      { text: 'Email', value: 'email' },
      { text: 'Ações', value: 'action', sortable: false }
    ],
    usuarios :[]
  }),

  created() {
    usuarioRepo.getAll().then(res => {
      this.usuarios = res.data;
    }).catch(console.error);
  },

  computed: {

  },

  methods: {
 remove: function(item){
                      this.$store.dispatch('remove/removeUsuario', {email: item.email})
                        .then(() => {
                                this.$router.push('/')
                        })
    }
  }
}
</script>
